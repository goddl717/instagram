package hyh.insutagram.service;

import hyh.insutagram.dto.RequestMemberDto;
import hyh.insutagram.dto.ResponseMemberDto;
import hyh.insutagram.entity.Member;
import hyh.insutagram.repository.MemberRepositry;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepositry memberRepositry;

    public MemberService(MemberRepositry memberRepositry)
    {
        this.memberRepositry = memberRepositry;
    }

    public List<ResponseMemberDto> selectAll(){
        return memberRepositry.findAll().stream().map(ResponseMemberDto::of).collect(Collectors.toList());
    }
    public ResponseMemberDto selectById(Long id){
        return ResponseMemberDto.of(memberRepositry.findById(id).get()) ;
    }
    public ResponseMemberDto insert(RequestMemberDto dto){
        Member member = Member.builder().id(dto.getId())
                                        .name(dto.getName())
                .registerTime(dto.getRegisterTime())
                .delFlag(dto.getDelFlag()).build();
        memberRepositry.save(member);
        return ResponseMemberDto.of(member);
    }

    public ResponseMemberDto update(RequestMemberDto dto){
        Member before =  memberRepositry.findById(dto.getId())
                .orElseThrow(()->new NoSuchElementException(""));
        Member after = Member.builder()
                .id(before.getId())
                .name(dto.getName())
                .registerTime(dto.getRegisterTime())
                .delFlag(dto.getDelFlag()).build();
        memberRepositry.save(after);
        return ResponseMemberDto.of(after);
    }
    public ResponseMemberDto delete(RequestMemberDto dto)
    {
        Member before = memberRepositry.findById(dto.getId())
                .orElseThrow(()->new NoSuchElementException("[delete error] : no such member"));
        memberRepositry.delete(before);
        return ResponseMemberDto.of(before);
    }
}

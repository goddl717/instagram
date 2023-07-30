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
        return memberRepositry.findAll().stream().map(Member::of).collect(Collectors.toList());
    }
    public ResponseMemberDto selectById(Long id){
        return Member.of(memberRepositry.findById(id).get()) ;
    }
    public ResponseMemberDto insert(RequestMemberDto dto){
        Member member = Member.builder().id(dto.getId())
                                        .name(dto.getName())
                .registerTime(dto.getRegisterTime())
                .delFlag(dto.getDelFlag()).build();
        memberRepositry.save(member);
        return Member.of(member);
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
        return Member.of(after);
    }
    public ResponseMemberDto delete(RequestMemberDto dto)
    {
        Member before = memberRepositry.findById(dto.getId())
                .orElseThrow(()->new NoSuchElementException("no data"));
        memberRepositry.delete(before);
        return Member.of(before);
    }
}

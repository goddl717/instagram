package hyh.insutagram.controller;

import hyh.insutagram.dto.RequestMemberDto;
import hyh.insutagram.dto.ResponseMemberDto;
import hyh.insutagram.repository.MemberRepositry;
import hyh.insutagram.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("members")
    public List<ResponseMemberDto> selectAll (){
        return memberService.selectAll();
    }
    @GetMapping("member")
    public ResponseMemberDto selectById (Long id){
        return memberService.selectById(id);
    }
    @PostMapping("member")
    public ResponseMemberDto insert (RequestMemberDto dto){
        return memberService.insert(dto);
    }
    @PutMapping("member")
    public ResponseMemberDto update (RequestMemberDto dto){
        return memberService.update(dto);
    }
    @DeleteMapping("member")
    public ResponseMemberDto delete (RequestMemberDto dto){
        return memberService.delete(dto);
    }
}

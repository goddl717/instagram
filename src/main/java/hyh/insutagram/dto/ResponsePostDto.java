package hyh.insutagram.dto;

import hyh.insutagram.entity.Member;
import hyh.insutagram.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
// TODO (진행 중) DTO 단에서의 entity 처리로 변환해야함.
public class ResponsePostDto {
    private Long id;
    private String title;
    private String contents;
    // todo DTO 단에서는 DTO 변수를 써야한다. test
    private ResponseMemberDto responseMemberDto;
    private LocalDate registerTime;
    private LocalDate updateTime;


}

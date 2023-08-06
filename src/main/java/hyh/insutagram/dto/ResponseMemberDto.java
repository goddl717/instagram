package hyh.insutagram.dto;

import hyh.insutagram.entity.Member;
import lombok.*;

import javax.persistence.NamedEntityGraph;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMemberDto {
    private Long id;
    private String name;
    private LocalDate registerTime;
    private Boolean delFlag;

    // entity 에서 dto 로 변환하는 함수 구현.
    public static ResponseMemberDto of(Member member){
        return ResponseMemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .registerTime(member.getRegisterTime())
                .delFlag(member.getDelFlag()).build();
    }
}

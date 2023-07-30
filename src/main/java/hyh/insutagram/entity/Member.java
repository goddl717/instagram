package hyh.insutagram.entity;

import hyh.insutagram.dto.ResponseMemberDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate registerTime;
    private Boolean delFlag;

    // entity 에서 dto 로 변환하는 함수 구현.
    public static ResponseMemberDto of(Member  member){
        return ResponseMemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .registerTime(member.getRegisterTime())
                .delFlag(member.getDelFlag()).build();
    }

}

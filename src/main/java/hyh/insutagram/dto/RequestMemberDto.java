package hyh.insutagram.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

//todo dto <-> entity 변환 함수는 어디에 작성해야하나 ? 인풋 데이터에 따라서 작성되어야 한다. 내생각엔...


public class RequestMemberDto {
    private Long id;
    private String name;
    private LocalDate registerTime;
    private Boolean delFlag;
}

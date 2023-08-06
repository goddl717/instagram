package hyh.insutagram.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class RequestMemberDto {
    private Long id;
    private String name;
    private LocalDate registerTime;
    private Boolean delFlag;

}

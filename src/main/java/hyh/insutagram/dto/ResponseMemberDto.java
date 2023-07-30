package hyh.insutagram.dto;

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
}

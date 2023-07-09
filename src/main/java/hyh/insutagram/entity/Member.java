package hyh.insutagram.entity;

import lombok.Builder;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Builder
public class Member {
    private Long id;

    private String name;
    private LocalDate registerTime;
    private Boolean delFlag;
}

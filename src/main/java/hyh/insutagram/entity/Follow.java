package hyh.insutagram.entity;

import lombok.Builder;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Builder
public class Follow {
    private Long id;

    private Member from;
    private Member to;

    private LocalDate registerTime;
}

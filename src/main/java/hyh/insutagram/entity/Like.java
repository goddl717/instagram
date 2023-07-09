package hyh.insutagram.entity;

import lombok.Builder;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Builder
public class Like {
    private Long id;

    private Post post;
    private Member member;

    private LocalDate registerTime;
}

package hyh.insutagram.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Member from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Member to;

    private LocalDate registerTime;
}

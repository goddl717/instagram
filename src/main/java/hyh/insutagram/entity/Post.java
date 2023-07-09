package hyh.insutagram.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")     // 연관관계 설정 member의 pk로 매핑됨.
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;
}

package hyh.insutagram.entity;

import hyh.insutagram.dto.ResponsePostDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")     // 연관관계 설정 member의 pk로 매핑됨.
    private Member member;
    // localDateTime으로
    private LocalDate registerTime;
    private LocalDate updateTime;

    // TODO set 대신 변환함수로 처리
    public void update(Post post) {

    }
}

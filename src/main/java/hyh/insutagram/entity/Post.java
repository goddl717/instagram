package hyh.insutagram.entity;

import hyh.insutagram.dto.ResponsePostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Post {
    public Post(){};
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

    public static ResponsePostDto toDTO (Post post){
        return ResponsePostDto.builder().id(post.getId())
                .title(post.getTitle())
                .contents(post.contents)
                .member(post.getMember())
                .registerTime(post.getRegisterTime())
                .updateTime(post.getUpdateTime()).build();
    }
}

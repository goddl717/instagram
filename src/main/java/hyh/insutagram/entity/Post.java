package hyh.insutagram.entity;

import hyh.insutagram.dto.ResponseMemberDto;
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
    // 왜 set을 안하냐??
    // 객체 변경 주기
    // 왜 이런 식으로 원하는 건ㅡ
    public void update(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.member = post.getMember();
        this.registerTime = post.getRegisterTime();
        this.updateTime = post.getUpdateTime();
    }
    public static ResponsePostDto of(Post post) {
        return ResponsePostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .responseMemberDto(ResponseMemberDto.of(post.getMember()))
                .registerTime(post.getRegisterTime())
                .updateTime(post.getUpdateTime())
                .build();
    }

    // static factory method
}

package hyh.insutagram.dto;

import hyh.insutagram.entity.Member;
import hyh.insutagram.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
// TODO DTO 단에서의 entity 처리
public class ResponsePostDto {
    private Long id;
    private String title;
    private String contents;
    // DTO 단에서는 DTO 변수를 써야한다.
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;

    // static factory method
    public static ResponsePostDto of(Post post) {
        return ResponsePostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .member(post.getMember())
                .registerTime(post.getRegisterTime())
                .updateTime(post.getUpdateTime())
                .build();
    }
}

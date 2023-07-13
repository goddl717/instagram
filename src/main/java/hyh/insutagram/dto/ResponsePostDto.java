package hyh.insutagram.dto;

import hyh.insutagram.entity.Member;
import hyh.insutagram.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
public class ResponsePostDto {
    private Long id;
    private String title;
    private String contents;
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;

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

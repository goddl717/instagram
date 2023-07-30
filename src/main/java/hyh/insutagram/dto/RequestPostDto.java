package hyh.insutagram.dto;

import hyh.insutagram.entity.Member;
import hyh.insutagram.entity.Post;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestPostDto {

    // TODO  DTO단에서의 entity 처리   ?? 무슨말인지 분석 필요
    private Long id;
    private String title;
    private String contents;
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;

    // ToDO 변환 함수 위치 ?? 여기에서 필요없다는 뜻같음.
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


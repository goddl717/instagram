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
    private Long id;
    private String title;
    private String contents;
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;
}


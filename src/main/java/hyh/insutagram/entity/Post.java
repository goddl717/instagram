package hyh.insutagram.entity;

import lombok.Builder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Builder
public class Post {
    private Long id;

    private String title;
    private String contents;
    private Member member;
    private LocalDate registerTime;
    private LocalDate updateTime;
}

package hyh.insutagram.controller;

import hyh.insutagram.dto.ResponsePostDto;
import hyh.insutagram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// controller 는 리턴 값으로 view 를 반환한다.
// 확인 필요
// restController는 json 을 반환한다 .
// restController는 생성자가 설정되어 있어야 한다.
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<ResponsePostDto> selectAll() {
        List<ResponsePostDto> posts = postService.selectAll();
        return posts;
    }
}

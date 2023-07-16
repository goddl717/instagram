package hyh.insutagram.controller;

import hyh.insutagram.dto.RequestPostDto;
import hyh.insutagram.dto.ResponsePostDto;
import hyh.insutagram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// controller 는 리턴 값으로 view 를 반환한다.
// 확인 필요
// restController는 json 을 반환한다 .
// restController는 생성자가 설정되어 있어야 한다.
@RestController
// restController 에는 reponseBody 포함되어 있음.
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<ResponsePostDto> selectAll() {
        return postService.selectAll();
    }

    @GetMapping("/post")
    public ResponsePostDto selectById(@RequestParam Long id) {
        return postService.selectById(id);
    }

    @PostMapping("/post")
    public ResponsePostDto insert(@RequestBody RequestPostDto dto) {
        return postService.insert(dto);
    }

    @PutMapping("/post")
    //반환차입.
    public ResponsePostDto update(@RequestBody RequestPostDto dto) {
        return postService.update(dto);
    }
}

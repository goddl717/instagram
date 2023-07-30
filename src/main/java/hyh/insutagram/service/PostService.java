package hyh.insutagram.service;

import hyh.insutagram.dto.RequestPostDto;
import hyh.insutagram.dto.ResponsePostDto;
import hyh.insutagram.entity.Post;
import hyh.insutagram.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    // TODO private final 이유
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<ResponsePostDto> selectAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(ResponsePostDto::of).collect(Collectors.toList());
    }

    // ToDO get 처리 방안
    // 함수형 프로그래밍 자바8 function, supplier
    public ResponsePostDto selectById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return ResponsePostDto.of(post.get());
    }

    public ResponsePostDto insert(RequestPostDto postdto) {
        Post post = Post.builder().title(postdto.getTitle())
                .member(postdto.getMember())
                .id(postdto.getId())
                .registerTime(postdto.getRegisterTime())
                .contents(postdto.getContents()).build();
        postRepository.save(post);
        return ResponsePostDto.of(post);
    }

    //TODO jpa 트랜잭션 지원
    public ResponsePostDto update(RequestPostDto dto) {
        Post postOpt = postRepository.findById(dto.getId())
                .orElseThrow(() -> new NoSuchElementException("jhgjghgj"));
        // TODO 멤버에 대한 예외 처리 로직도 추가.
        Post post = Post.builder()
                .id(postOpt.getId())
                .title(dto.getTitle())
                .updateTime(dto.getUpdateTime())
                .member(dto.getMember())
                .registerTime(dto.getRegisterTime())
                .updateTime(dto.getUpdateTime())
                .build();

        postOpt.update(post);
        postRepository.save(post);
        return ResponsePostDto.of(post);
    }
}

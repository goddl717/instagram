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
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<ResponsePostDto> selectAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(ResponsePostDto::of).collect(Collectors.toList());
    }

    public ResponsePostDto selectById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        return Post.toDTO(post.get());
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

    public ResponsePostDto update(RequestPostDto dto) {
        Optional<Post> postOpt = postRepository.findById(dto.getId());
        if (postOpt.isPresent()) {
            Post post = Post.builder()
                    .id(postOpt.get().getId())
                    .title(dto.getTitle())
                    .updateTime(dto.getUpdateTime())
                    .member(dto.getMember())
                    .registerTime(dto.getRegisterTime())
                    .updateTime(dto.getUpdateTime())
                    .build();
            postRepository.save(post);
            return ResponsePostDto.of(post);
        } else
            throw new NoSuchElementException("jhgjghgj");
    }
}

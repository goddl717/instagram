package hyh.insutagram.service;

import hyh.insutagram.dto.ResponsePostDto;
import hyh.insutagram.entity.Post;
import hyh.insutagram.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

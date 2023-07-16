package hyh.insutagram.repository;

import hyh.insutagram.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpaRepository를 사용할 수 있다.
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

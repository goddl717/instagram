package hyh.insutagram.repository;

import hyh.insutagram.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositry extends JpaRepository<Member,Long> {
}

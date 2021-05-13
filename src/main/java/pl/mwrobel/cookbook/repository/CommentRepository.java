package pl.mwrobel.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mwrobel.cookbook.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


}

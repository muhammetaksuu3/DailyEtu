package DailtyEtu.DailtyEtu.repository;

import DailtyEtu.DailtyEtu.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}

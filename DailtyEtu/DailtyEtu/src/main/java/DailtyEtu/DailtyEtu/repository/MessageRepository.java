package DailtyEtu.DailtyEtu.repository;

import DailtyEtu.DailtyEtu.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}

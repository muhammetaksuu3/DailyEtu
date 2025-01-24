package DailtyEtu.DailtyEtu.repository;

import DailtyEtu.DailtyEtu.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}

package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id", nullable = false)
    private User kullanici;

    private String tur;
    private String mesaj;

    private LocalDateTime tarih;
}
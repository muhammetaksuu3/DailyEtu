package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "followers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "takip_eden_id", nullable = false)
    private User takipEden;

    @ManyToOne
    @JoinColumn(name = "takip_edilen_id", nullable = false)
    private User takipEdilen;

    private LocalDateTime tarih;
}
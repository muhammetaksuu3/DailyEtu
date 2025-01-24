package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "likes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gonderi_id", nullable = false)
    private Post gonderi;

    @ManyToOne
    @JoinColumn(name = "kullanici_id", nullable = false)
    private User kullanici;
}

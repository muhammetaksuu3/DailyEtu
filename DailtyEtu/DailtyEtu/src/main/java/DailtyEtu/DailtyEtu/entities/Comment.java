package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gonderi_id", nullable = false)
    private Post gonderi;

    @ManyToOne
    @JoinColumn(name = "kullanici_id", nullable = false)
    private User kullanici;

    private String icerik;

    private LocalDateTime tarih;
}
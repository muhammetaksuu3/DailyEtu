package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gonderen_id", nullable = false)
    private User gonderen;

    @ManyToOne
    @JoinColumn(name = "alici_id", nullable = false)
    private User alici;

    private String icerik;

    private LocalDateTime tarih;
}

package DailtyEtu.DailtyEtu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id", nullable = false)
    private User kullanici;

    private String baslik;
    private String icerik;

    private String gorsel;

    @ElementCollection
    private List<String> etiketler;

    private LocalDateTime olusturulmaTarihi;
}


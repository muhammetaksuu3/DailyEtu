package DailtyEtu.DailtyEtu.business.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest{
    private String ad;

    private String soyad;

    private String biyografi;

    @Size(min = 6, max = 55, message = "Password'un boyutu minimum {min}, maksimum {max} olmalıdır")
    @NotBlank(message = "Parola boş olamaz")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{6,55}$", message = "Parola en az bir büyük harf, bir küçük harf, bir sayı ve bir özel karakter içermelidir")
    private String password;


    @NotBlank(message = "Kullanıcı adı boş olamaz")
    @Size(min = 4, max = 55, message = "Username'in boyutu minimum {min}, maksimum {max} olmalıdır")
    @Column(unique = true)  // Veritabanında benzersiz olmasını sağlar
    private String username;

    @NotBlank(message = "Email boş olamaz")
    @Email(message = "Geçerli bir email adresi girin")
    @Column(unique = true)  // Veritabanında benzersiz olmasını sağlar
    private String email;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBiyografi() {
        return biyografi;
    }

    public void setBiyografi(String biyografi) {
        this.biyografi = biyografi;
    }

    public @Size(min = 6, max = 55, message = "Password'un boyutu minimum {min}, maksimum {max} olmalıdır") @NotBlank(message = "Parola boş olamaz") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{6,55}$", message = "Parola en az bir büyük harf, bir küçük harf, bir sayı ve bir özel karakter içermelidir") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, max = 55, message = "Password'un boyutu minimum {min}, maksimum {max} olmalıdır") @NotBlank(message = "Parola boş olamaz") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{6,55}$", message = "Parola en az bir büyük harf, bir küçük harf, bir sayı ve bir özel karakter içermelidir") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Kullanıcı adı boş olamaz") @Size(min = 4, max = 55, message = "Username'in boyutu minimum {min}, maksimum {max} olmalıdır") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Kullanıcı adı boş olamaz") @Size(min = 4, max = 55, message = "Username'in boyutu minimum {min}, maksimum {max} olmalıdır") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Email boş olamaz") @Email(message = "Geçerli bir email adresi girin") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email boş olamaz") @Email(message = "Geçerli bir email adresi girin") String email) {
        this.email = email;
    }
}

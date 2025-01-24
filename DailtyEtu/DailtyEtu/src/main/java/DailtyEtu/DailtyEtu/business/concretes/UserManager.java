package DailtyEtu.DailtyEtu.business.concretes;

import DailtyEtu.DailtyEtu.auth.JWTService;
import DailtyEtu.DailtyEtu.business.absracts.UserService;
import DailtyEtu.DailtyEtu.business.request.*;
import DailtyEtu.DailtyEtu.business.request.LoginRequest;
import DailtyEtu.DailtyEtu.entities.User;
import DailtyEtu.DailtyEtu.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
@Service
public class UserManager implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;


    @Override
    public ResponseEntity<?> add(CreateUserRequest createUserRequest) {

        if (userRepository.existsByUsername((createUserRequest.getUsername()))){
            Map<String, String> errors = new HashMap<>();
            errors.put("username", "Username kullanılmıştır");
            return ResponseEntity.badRequest().body(errors); // Hata mesajı Map olarak dönülür
        }

        if (userRepository.existsByEmail(createUserRequest.getEmail())) {
            Map<String, String> errors = new HashMap<>();
            errors.put("email", "Mail kullanılmıştır");
            return ResponseEntity.badRequest().body(errors); // Hata mesajı Map olarak dönülür
        }

        try {
            User user = new User();
            user.setEmail(createUserRequest.getEmail());
            String password = passwordEncoder.encode(createUserRequest.getPassword());
            user.setPassword(password);
            user.setUsername(createUserRequest.getUsername());
            user.setAd(createUserRequest.getAd());
            user.setSoyad(createUserRequest.getSoyad());
            user.setBiyografi(createUserRequest.getBiyografi());

            userRepository.save(user);

            return ResponseEntity.ok("true");
        } catch (Exception e) {
            return ResponseEntity.ok("false");
        }

    }


    @Override
    public ResponseEntity<String> logIn(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Kullanıcı bulunamadı");
        }
        String jwtToken = jwtService.generateToken(user);
        return ResponseEntity.ok(jwtToken);
    }


}

package DailtyEtu.DailtyEtu.business.absracts;

import DailtyEtu.DailtyEtu.business.request.CreateUserRequest;
import DailtyEtu.DailtyEtu.business.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

     ResponseEntity<?> add(CreateUserRequest createUserRequest);

     ResponseEntity<String> logIn(LoginRequest loginRequest);
}

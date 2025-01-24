package DailtyEtu.DailtyEtu.controller;

import DailtyEtu.DailtyEtu.auth.JWTService;
import DailtyEtu.DailtyEtu.business.absracts.UserService;
import DailtyEtu.DailtyEtu.business.request.CreateUserRequest;
import DailtyEtu.DailtyEtu.business.request.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JWTService jwtService;   // @Autowired gereksiz

    @Autowired
    private UserService userService; // @Autowired gereksiz

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody CreateUserRequest createUserRequest) {
        return userService.add(createUserRequest);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody LoginRequest loginRequest) {
        return userService.logIn(loginRequest);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}



package resumeBuider.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resumeBuider.Repository.UserLoginRepository;
import resumeBuider.model.UserLogin;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final UserLoginRepository repository;

    public LoginController(UserLoginRepository repository) {
        this.repository = repository;
    }

    // ✅ REGISTER USER
    @GetMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String email,
                                          @RequestParam String password) {

        if (repository.findByEmailAndPassword(email, password).isPresent()) {
            return ResponseEntity.status(400).body("User already exists");
        }

        UserLogin user = new UserLogin();
        user.setEmail(email);
        user.setPassword(password);
        repository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    // ✅ LOGIN USER
    @GetMapping
    public ResponseEntity<?> login(@RequestParam String email,
                                   @RequestParam String password) {

        return repository.findByEmailAndPassword(email, password)
                .map(user -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid email or password"));
    }
}


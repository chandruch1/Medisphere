package api.request.controller;

import api.request.Repository.UserRepo;
import api.request.service.UserSer;
import api.request.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import todo.User;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthCont {

    private final UserSer us;
    private final UserRepo ur;
    private final JwtUtils jw;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        if (ur.findByEmail(email).isPresent()) {
            return new ResponseEntity<>(
                    "Already Registered",
                    HttpStatus.CONFLICT
            );
        }

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();

        us.create(user);

        return new ResponseEntity<>(
                "Registration Successful",
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        var userOp = ur.findByEmail(email);

        if (userOp.isEmpty()) {
            return new ResponseEntity<>(
                    "Please Register",
                    HttpStatus.NOT_FOUND
            );
        }

        User user = userOp.get();

        if (!passwordEncoder.matches(
                password,
                user.getPassword())) {

            return new ResponseEntity<>(
                    "Invalid Password",
                    HttpStatus.UNAUTHORIZED
            );
        }

        String token = jw.generateToken(email);

        return ResponseEntity.ok(
                Map.of("token", token)
        );
    }
}
package com.mithra.documerge.documerge.controller;

import com.mithra.documerge.documerge.dto.RegisterRequest;
import com.mithra.documerge.documerge.model.User;
import com.mithra.documerge.documerge.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.registerUser(request.getEmail(), request.getPassword(), request.getRole());
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/user")
    public ResponseEntity<Optional<User>> getUser(@RequestParam String email) {
        return ResponseEntity.ok(authService.findByEmail(email));
    }
}

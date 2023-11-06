package com.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.service.AuthService;

import com.server.dto.AuthRequest;
import com.server.dto.RegisterRequest;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody AuthRequest authRequest) {
        String token = authService.loginUser(authRequest.getEmail(), authRequest.getPassword());
        return ResponseEntity.ok(token);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        String token = authService.registerUser(
            registerRequest.getEmail(),
            registerRequest.getPassword(),
            registerRequest.getConfirmPassword(),
            registerRequest.getUsername()
        );
        return ResponseEntity.ok(token);
	}
}

package com.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.service.AuthService;

import com.server.dto.AuthRequest;
import com.server.dto.AuthResponse;
import com.server.dto.RegisterRequest;
import com.server.dto.RegisterResponse;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest authRequest) {
        AuthResponse token = authService.loginUser(authRequest);
        return ResponseEntity.ok(token);
	}

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse token = authService.registerUser(registerRequest);
        return ResponseEntity.ok(token);
	}
}

package com.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.service.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

	@PostMapping("/login")
	public String loginUser(String email, String password) {
		return authService.loginUser(email, password);
	}

	@PostMapping("/register")
	public String registerUser(String email, String password, String confirmPassword, String username) {
		return authService.registerUser(email, password, confirmPassword, username);
	}
}

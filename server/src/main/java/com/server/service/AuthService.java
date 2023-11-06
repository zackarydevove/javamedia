package com.server.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.server.model.User;
import com.server.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String ISSUER = "your-app-name";
    private static final long EXPIRATION_TIME = 864_000_000;
    private static final String SECRET = "your-secret-key";

	public String loginUser(String email, String password) {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (!isPasswordValid(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new IllegalArgumentException("User does not exist");
		}
	
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new IllegalArgumentException("Invalid password");
		}

        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC512(SECRET));

        return token;
	}

    public String registerUser(String email, String password, String confirmPassword, String username) {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (!isPasswordValid(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        if (!isUsernameValid(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("User with email already exists");
        }

        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username is already taken");
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(email, hashedPassword, username);
        userRepository.save(user);

        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC512(SECRET));

        return token;
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    	return email.matches(emailRegex);
    }

	// a-z A-Z 0-9 !@#$%^&*()_+=-{}|:<>? 8+
    private boolean isPasswordValid(String password) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=\\-{}|:<>?]).{8,}$";
		return password.matches(passwordRegex);
    }

    private boolean isUsernameValid(String username) {
        String usernameRegex = "^[a-z]+$";
    	return username.matches(usernameRegex);
    }
}

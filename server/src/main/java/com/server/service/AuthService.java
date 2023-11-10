package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.server.configuration.UserAuthProvider;
import com.server.dto.AuthRequest;
import com.server.dto.AuthResponse;
import com.server.dto.RegisterRequest;
import com.server.dto.RegisterResponse;
import com.server.model.User;
import com.server.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private UserAuthProvider userAuthProvider;

	public AuthResponse loginUser(AuthRequest authRequest) {
		String email = authRequest.getEmail();
		String password = authRequest.getPassword();

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

        String token = userAuthProvider.createToken(user.getUsername());

		AuthResponse response = new AuthResponse(token);

        return response;
	}

    public RegisterResponse registerUser(RegisterRequest registerRequest) {
		String email = registerRequest.getEmail();
		String password = registerRequest.getPassword();
		String confirmPassword = registerRequest.getConfirmPassword();
		String username = registerRequest.getUsername();

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

        String token = userAuthProvider.createToken(username);

		RegisterResponse response = new RegisterResponse(token);

        return response;
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    	return email.matches(emailRegex);
    }

    private boolean isPasswordValid(String password) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=\\-{}|:<>?]).{8,}$";
		return password.matches(passwordRegex);
    }

    private boolean isUsernameValid(String username) {
        String usernameRegex = "^[a-z]+$";
    	return username.matches(usernameRegex);
    }
}

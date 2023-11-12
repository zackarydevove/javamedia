package com.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.server.dto.user.ChangePasswordRequest;
import com.server.dto.user.ChangeUsernameRequest;
import com.server.model.User;
import com.server.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	public Boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
	}

	public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
	}

	public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
	}

	public User getUserByToken(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);

			String username = jwt.getSubject();

			return userRepository.findByUsername(username);
		} catch (Exception e) {
			return null;
		}
	}

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

    public List<User> getThreeRandomUsers(Long id) {
        List<User> allUsers = userRepository.findAll();
        allUsers.removeIf(user -> user.getId().equals(id));

        Random random = new Random();
        List<User> randomUsers = new ArrayList<>();
        int count = 0;
        while (count < 3 && !allUsers.isEmpty()) {
            randomUsers.add(allUsers.remove(random.nextInt(allUsers.size())));
            count++;
        }
        return randomUsers;
    }

	public User changeUsername(ChangeUsernameRequest request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUsername(request.getNewUsername());
            userRepository.save(user);
            return user;
        }
        return null;
	}

    public User changePassword(ChangePasswordRequest request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(request.getNewPassword()));
                userRepository.save(user);
                return user;
            }
        }
        return null;
    }

	public List<User>  searchUsers(String term) {
        List<User> matchedUsers = userRepository.findByUsernameContaining(term);
        return matchedUsers;
	}

}

package com.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.server.dto.user.ChangePasswordRequest;
import com.server.dto.user.ChangeUsernameRequest;
import com.server.model.User;
import com.server.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        Boolean deleted = userService.deleteUser(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		if (user.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
		if (user.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
		if (user.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
    }

    @GetMapping("/by-token/{token}")
    public ResponseEntity<User> getUserByToken(@PathVariable String token) {
        User user = userService.getUserByToken(token);
		if (user.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
    }

    @GetMapping("/random-users/{userId}")
    public ResponseEntity<List<User>> getThreeRandomUsers(@PathVariable Long userId) {
        List<User> users = userService.getThreeRandomUsers(userId);
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/username")
    public ResponseEntity<User> changeUsername(@RequestBody ChangeUsernameRequest request) {
        User updatedUser = userService.changeUsername(request);
		if (updatedUser.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/password")
    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordRequest request) {
        User updatedUser = userService.changePassword(request);
		if (updatedUser.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<User>> searchUsers(@PathVariable String term) {
        List<User> users = userService.searchUsers(term);
        return ResponseEntity.ok(users);
    }

}

package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.server.service.FollowService;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity<?> follow(@RequestParam Long followerId, @RequestParam Long followingId) {
        if (followService.follow(followerId, followingId)) {
            return ResponseEntity.ok("Followed successfully");
        }
        return ResponseEntity.badRequest().body("Follow operation failed");
    }

    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollow(@RequestParam Long followerId, @RequestParam Long followingId) {
        if (followService.unfollow(followerId, followingId)) {
            return ResponseEntity.ok("Unfollowed successfully");
        }
        return ResponseEntity.badRequest().body("Unfollow operation failed");
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkFollow(@RequestParam Long followerId, @RequestParam Long followingId) {
        boolean isFollowing = followService.checkFollow(followerId, followingId);
        return ResponseEntity.ok(isFollowing);
    }
}

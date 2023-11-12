package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.server.service.LikeService;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<String> likePost(@RequestParam Long userId, @PathVariable Long postId) {
        if (likeService.likePost(userId, postId)) {
            return ResponseEntity.ok("Liked post successfully");
        }
        return ResponseEntity.badRequest().body("Like postoperation failed");
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> unlikePost(@RequestParam Long userId, @PathVariable Long postId) {
        if (likeService.unlikePost(userId, postId)) {
            return ResponseEntity.ok("Unliked post successfully");
        }
        return ResponseEntity.badRequest().body("Unlike post operation failed");
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Boolean> checkLikePost(@RequestParam Long userId, @PathVariable Long postId) {
        boolean isLiked = likeService.checkLikePost(userId, postId);
        return ResponseEntity.ok(isLiked);
    }


    // @PostMapping("/comment/{commentId}")
    // public ResponseEntity<?> likeComment(@RequestParam Long userId, @PathVariable Long commentId) {
    //     if (likeService.likeComment(userId, commentId)) {
    //         return ResponseEntity.ok("Liked comment successfully");
    //     }
    //     return ResponseEntity.badRequest().body("Like post operation failed");
    // }

    // @DeleteMapping("/comment/{commentId}")
    // public ResponseEntity<?> unlikeComment(@RequestParam Long userId, @PathVariable Long commentId) {
    //     if (likeService.unlikeComment(userId, commentId)) {
    //         return ResponseEntity.ok("Unliked comment successfully");
    //     }
    //     return ResponseEntity.badRequest().body("Unlike post operation failed");
    // }

}

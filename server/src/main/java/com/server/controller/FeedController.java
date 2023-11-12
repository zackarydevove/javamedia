package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.server.model.Post;
import com.server.service.FeedService;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getFeed(@PathVariable Long userId, 
												@RequestParam(defaultValue = "0") int page, 
												@RequestParam(defaultValue = "10") int size) {
		List<Post> feed = feedService.getFeed(userId, page, size);
		return ResponseEntity.ok(feed);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<List<Post>> getProfileFeed(@PathVariable Long userId, 
                                                     @RequestParam(defaultValue = "0") int page, 
                                                     @RequestParam(defaultValue = "10") int size) {
        List<Post> profileFeed = feedService.getProfileFeed(userId, page, size);
        return ResponseEntity.ok(profileFeed);
    }
}

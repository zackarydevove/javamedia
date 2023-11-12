package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.server.model.Post;
import com.server.model.User;
import com.server.repository.FollowRepository;
import com.server.repository.PostRepository;
import com.server.repository.UserRepository;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FollowRepository followRepository;

    public List<Post> getFeed(Long userId, int page, int size) {
        List<User> following = followRepository.findFollowingByUserId(userId);

        PageRequest pageRequest = PageRequest.of(page, size);
        return postRepository.findByCreatorInOrderByCreatedAtDesc(following, pageRequest);
    }


    public List<Post> getProfileFeed(Long userId, int page, int size) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        PageRequest pageRequest = PageRequest.of(page, size);
        return postRepository.findByCreatorOrderByCreatedAtDesc(user, pageRequest);
    }
}

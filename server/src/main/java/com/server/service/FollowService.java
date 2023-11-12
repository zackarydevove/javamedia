package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.model.Follow;
import com.server.repository.FollowRepository;
import com.server.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean follow(Long followerId, Long followingId) {
        if (!followRepository.existsByFollowerIdAndFollowingId(followerId, followingId)) {
            Follow follow = new Follow();
            follow.setFollower(userRepository.findById(followerId).orElse(null));
            follow.setFollowing(userRepository.findById(followingId).orElse(null));
            follow.setCreatedAt(LocalDateTime.now());
            followRepository.save(follow);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean unfollow(Long followerId, Long followingId) {
        Follow follow = followRepository.findByFollowerIdAndFollowingId(followerId, followingId);
        if (follow != null) {
            followRepository.delete(follow);
            return true;
        }
        return false;
    }

    public boolean checkFollow(Long followerId, Long followingId) {
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }
}

package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.server.model.Like;
import com.server.model.Post;
import com.server.model.User;
import com.server.repository.LikeRepository;
import com.server.repository.PostRepository;
import com.server.repository.UserRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public boolean likePost(Long userId, Long postId) {
        if (!likeRepository.existsByUserIdAndPostId(userId, postId)) {
            User user = userRepository.findById(userId).orElse(null);
            Post post = postRepository.findById(postId).orElse(null);
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            likeRepository.save(like);
            return true;
        }
        return false;
    }

    public boolean unlikePost(Long userId, Long postId) {
        Like like = likeRepository.findByUserIdAndPostId(userId, postId);
        if (like != null) {
            likeRepository.delete(like);
            return true;
        }
        return false;
    }

    public boolean checkLikePost(Long userId, Long postId) {
        return likeRepository.existsByUserIdAndPostId(userId, postId);
    }

    // public boolean likeComment(Long userId, Long commentId) {
    //     if (!likeRepository.existsByUserIdAndCommentId(userId, commentId)) {
    //         User user = userRepository.findById(userId).orElse(null);
    //         Comment comment = commentRepository.findById(commentId).orElse(null);
    //         Like like = new Like();
    //         like.setUser(user);
    //         like.setComment(comment);
    //         likeRepository.save(like);
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean unlikeComment(Long userId, Long commentId) {
    //     Like like = likeRepository.findByUserIdAndCommentId(userId, commentId);
    //     if (like != null) {
    //         likeRepository.delete(like);
    //         return true;
    //     }
    //     return false;
    // }
}

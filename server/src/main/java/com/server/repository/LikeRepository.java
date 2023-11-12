package com.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.server.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
	
    boolean existsByUserIdAndPostId(Long userId, Long postId);

	Like findByUserIdAndPostId(Long userId, Long postId);

}

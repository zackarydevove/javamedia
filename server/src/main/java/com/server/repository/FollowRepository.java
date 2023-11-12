package com.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.server.model.Follow;
import com.server.model.User;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    
	boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

	Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId);
	
    List<User> findFollowingByUserId(Long userId);
	
}

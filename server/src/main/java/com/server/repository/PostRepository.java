package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.server.model.Post;
import com.server.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCreator(User creator);

	List<Post> findByCreatorInOrderByCreatedAtDesc(List<User> following, Pageable pageable);

    List<Post> findByCreatorOrderByCreatedAtDesc(User user, Pageable pageable);

}

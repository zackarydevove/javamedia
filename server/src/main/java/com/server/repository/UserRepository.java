package com.server.repository;

import com.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
    
    boolean existsByUsername(String username);

	User findByEmail(String email);

}
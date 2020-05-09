package com.ecomplify.eventmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecomplify.eventmanagement.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
       User findByEmail(String email);
       User findByAppuserid(Long appuserid);
}

package com.ecomplify.eventmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.models.entities.UserIdentifier;

@Repository
public interface UserIdentifierRepository extends JpaRepository<UserIdentifier, Long> {
	
	UserIdentifier findByUserId(Long userId);
	

}

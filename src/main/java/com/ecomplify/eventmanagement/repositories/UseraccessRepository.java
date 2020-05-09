package com.ecomplify.eventmanagement.repositories;

import com.ecomplify.eventmanagement.models.entities.User;
import com.ecomplify.eventmanagement.models.entities.UserAccessibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseraccessRepository extends JpaRepository<UserAccessibility, Long> {

    UserAccessibility findByAppuserid(Long appuserid);

}

package com.ecomplify.eventmanagement.repositories;

import com.ecomplify.eventmanagement.models.entities.AppEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppEventRepository extends JpaRepository<AppEvent, Long> {
	
	 AppEvent findByEventname(String eventname);
	

}

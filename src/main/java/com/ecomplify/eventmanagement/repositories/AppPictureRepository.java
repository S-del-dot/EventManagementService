package com.ecomplify.eventmanagement.repositories;

import com.ecomplify.eventmanagement.models.entities.AppEvent;
import com.ecomplify.eventmanagement.models.entities.AppPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPictureRepository extends JpaRepository<AppPicture, Long> {

	List<AppPicture> findByAppeventid(Long appeventid);



}

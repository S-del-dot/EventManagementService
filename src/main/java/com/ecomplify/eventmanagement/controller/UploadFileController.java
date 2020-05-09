package com.ecomplify.eventmanagement.controller;

import com.ecomplify.eventmanagement.models.entities.AppPicture;
import com.ecomplify.eventmanagement.repositories.AppPictureRepository;
import com.ecomplify.eventmanagement.services.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
public class UploadFileController {

	@Autowired
	S3Services s3Services;

	@Autowired
	AppPictureRepository AppPictureRepo;


	//@RequestMapping(value = "/api/file/upload", method = RequestMethod.POST)
	@PostMapping("/api/file/upload")
	public void uploadMultipartFile(@RequestParam("keyname") String keyName,
								                        @RequestParam("createdby") String createdby,
														@RequestParam("uploadfile") MultipartFile file) {

		s3Services.uploadFile(keyName, file, createdby);

	}
}

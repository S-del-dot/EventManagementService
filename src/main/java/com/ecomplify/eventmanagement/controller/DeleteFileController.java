package com.ecomplify.eventmanagement.controller;


import com.ecomplify.eventmanagement.services.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
public class DeleteFileController {
 	
	@Autowired
	S3Services s3Services;

	@DeleteMapping("/api/file/delete/{keyname}")
	public String uploadMultipartFile(@PathVariable String keyname) {
		try {
			s3Services.deleteFile(keyname);
		}catch(Exception e) {
			return "Cannot Delete File -> Keyname = " + keyname;
		}
		return "Delete Successfully -> Keyname = " + keyname;
	}

}

package com.ecomplify.eventmanagement.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

public interface S3Services {
	public ByteArrayOutputStream downloadFile(String keyName);
	public void uploadFile(String keyName, MultipartFile file, String createdby);
	public void deleteFile(String keyName);

}
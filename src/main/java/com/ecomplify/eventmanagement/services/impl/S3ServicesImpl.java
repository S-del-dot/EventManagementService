package com.ecomplify.eventmanagement.services.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;

import com.amazonaws.util.IOUtils;
import com.ecomplify.eventmanagement.models.entities.AppEvent;

import com.ecomplify.eventmanagement.models.entities.AppPicture;
import com.ecomplify.eventmanagement.repositories.AppEventRepository;
import com.ecomplify.eventmanagement.repositories.AppPictureRepository;
import com.ecomplify.eventmanagement.services.ApplicationBusinessService;
import com.ecomplify.eventmanagement.services.S3Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@Service
public class S3ServicesImpl implements S3Services {
	
	private Logger logger = LoggerFactory.getLogger(S3ServicesImpl.class);
	
	@Autowired
	private AmazonS3 s3client;

    @Autowired
    AppPictureRepository AppPictureRepo;

 
	@Value("${gkz.s3.bucket}")
	private String bucketName;

    @Value("${gkz.aws.endpoint_url}")
    private String endpointurl;
 
	@Override
	public ByteArrayOutputStream downloadFile(String keyName) {
		try {
            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
            
            InputStream is = s3object.getObjectContent();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[4096];
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, len);
            }
            
            return baos;

		}

		 catch (IOException ioe) {
			logger.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException ase) {
        	logger.info("sCaught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
			throw ase;
        } catch (AmazonClientException ace) {
        	logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
            throw ace;
        }
		
		return null;
	}
 
	@Override
	public void uploadFile(String keyName, MultipartFile file, String createdby) {
        String fileUrl = "";

		try {
            AppPicture apppic = new AppPicture();
            fileUrl = endpointurl + "/" + bucketName + "/" + keyName;
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			s3client.putObject(new PutObjectRequest(bucketName, keyName, file.getInputStream(), metadata)
					.withCannedAcl(CannedAccessControlList.PublicRead));
            apppic.setImage_url(fileUrl);
            apppic.setImagename(keyName);
			apppic.setDeleted("N");
			apppic.setPicturesize(file.getSize());
			apppic.setCreatedon(LocalDateTime.now());
			apppic.setModifiedon(LocalDateTime.now());
            apppic.setCreatedby(createdby);
			apppic.setAppeventid(new Long(5));
            AppPictureRepo.save(apppic);

		} catch(IOException ioe) {
			logger.error("IOException: " + ioe.getMessage());
		} catch (AmazonServiceException ase) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
			throw ase;
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
            throw ace;
        }
	}

    @Override
    public void deleteFile(String keyName) {
        try {
            s3client.deleteObject(new DeleteObjectRequest(bucketName, keyName));
        } catch(AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
            throw ase;
        } catch (SdkClientException sce) {
            logger.info("Caught an SdkClientException: ");
            logger.info("Error Message: " + sce.getMessage());
            throw sce;
        }
    }
}

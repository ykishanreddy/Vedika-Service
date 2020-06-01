package com.vedika.functionhall.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.vedika.functionhall.model.AwsCredentials;
@Service
public class S3ServicesImpl implements S3Services {
	
	
	
	@Autowired
	private AmazonS3 s3client;
 
	@Value("${s3.bucket}")
	private String bucketName;
 
	
 
	@Override
	public void uploadFileToS3Bucket(String keyName, MultipartFile file) {
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			s3client.putObject(bucketName, keyName, file.getInputStream(), metadata);
		} catch(IOException ioe) {
			System.out.println("IOException: " + ioe.getMessage());
		} 
        
	}



 /*	@Override
	public List<AwsCredentials> getAll() {
		// TODO Auto-generated method stub
		return s3client.getAll();
	}



	@Override
	public AwsCredentials saveOrUpdateAwsCredentials(AwsCredentials awsCredentials) {
		return s3client.save(awsCredentials);

	}
	*/




}


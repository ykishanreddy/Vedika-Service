package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.AwsCredentials;

public interface S3Services {
	
	
	public void uploadFileToS3Bucket(String keyName, MultipartFile file);

	//List<AwsCredentials> getAll();

//	public List<AwsCredentials> getAll();

//	public AwsCredentials saveOrUpdateAwsCredentials(AwsCredentials awsCredentials);

}

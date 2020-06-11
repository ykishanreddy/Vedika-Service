package com.vedika.functionhall.service;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Services {
	
	public ByteArrayOutputStream downloadFile(String corelationId);
	

	public void uploadFile(String corelationId, MultipartFile file);

	public List<String> listFiles();
	/* public URL storeObjectInS3(MultipartFile file, String corelationId);*/


	

}

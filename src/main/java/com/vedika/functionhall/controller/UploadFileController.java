package com.vedika.functionhall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.service.S3Services;
 
@RestController
@RequestMapping("/api")
public class UploadFileController {
	
	@Autowired
   private 	S3Services s3Services;
	
	
	@Value("${s3.bucket}") 
	private String bucketName;
	 
    @PostMapping(value="/image")
    public Map<String, String> uploadFile(@RequestPart(value = "corelationId") String corelationId, MultipartFile file)
    {
    	
        this.s3Services.uploadFile(corelationId, file);
         
        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");
       
        return response;
    }
    
	
    
}
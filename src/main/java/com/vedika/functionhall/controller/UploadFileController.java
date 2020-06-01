package com.vedika.functionhall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.AwsCredentials;
import com.vedika.functionhall.service.S3Services;
 
@RestController
@RequestMapping("/files")
public class UploadFileController {
	
	@Autowired
   private 	S3Services s3Services;
	 
    @PostMapping
    public Map<String, String> uploadFile(@RequestPart(value = "keyname") String keyName, MultipartFile file)
    {
        this.s3Services.uploadFileToS3Bucket(keyName, file);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        return response;
    }
    
	
    
}
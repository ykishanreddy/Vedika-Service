package com.vedika.functionhall.controller;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.service.S3Services;
  
@RestController
public class DownloadFileController {
 	
	@Autowired
	S3Services s3Services;
	
	@GetMapping("/api/file/{corelationId}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String corelationId) {
		ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(corelationId);
	
		return ResponseEntity.ok()
					.contentType(contentType(corelationId))
					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; corelationid=\"" + corelationId + "\"")
					.body(downloadInputStream.toByteArray());	
	}
	 
	/*@GetMapping(value="/api/{corelationId}")
	 public  URL  upload(@PathVariable (value = "corelationId") String corelationId, MultipartFile file) {
       URL url = s3Services.storeObjectInS3(file, file.getOriginalFilename());
       return url;
   }
   */
       
		
	@GetMapping("/api/files")
	public List<String> listAllFiles(){
		return s3Services.listFiles();
	}
	
	private MediaType contentType(String corelationId) {
		String[] arr = corelationId.split("\\.");
		String type = arr[arr.length-1];
		switch(type) {
	     	case "txt": return MediaType.TEXT_PLAIN;
			case "png": return MediaType.IMAGE_PNG;
			case "jpg": return MediaType.IMAGE_JPEG;
			default: return MediaType.APPLICATION_FORM_URLENCODED;
		}
	}
}

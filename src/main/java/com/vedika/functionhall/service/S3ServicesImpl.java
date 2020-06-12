package com.vedika.functionhall.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

 
@Service
public class S3ServicesImpl implements S3Services {
	
	private Logger logger = LoggerFactory.getLogger(S3ServicesImpl.class);
	
	@Autowired
	private AmazonS3 s3client;
 
	@Value("${s3.bucket}")
	private String bucketName;
 
	@Override
	public ByteArrayOutputStream downloadFile(String corelationId) {
		try {
            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, corelationId));
            
            InputStream is = s3object.getObjectContent();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[4096];
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, len);
            }
            
            return baos;
		} catch (IOException ioe) {
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
	public void uploadFile(String corelationId, MultipartFile file) {
		
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			
			
			
			
		s3client.putObject(new PutObjectRequest(bucketName, corelationId,file.getInputStream(), metadata).withCannedAcl(CannedAccessControlList.PublicRead));
		s3client.getUrl("bucketName", "corelationId").toString();
		System.out.println("filelink: " + s3client.getUrl(bucketName, corelationId));
		 
		URL url1=s3client.getUrl(bucketName, corelationId) ;	 
		System.out.println("file:" +s3client.getUrl(corelationId, bucketName));
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
	
	 public String getResourceUrl(String corelationId ) throws FileNotFoundException
	 {
	     try {
	         return s3client.generatePresignedUrl(bucketName, corelationId, new DateTime().plusMinutes(5).toDate()).toString();
	     }
	     catch (AmazonS3Exception exception){
	         if(exception.getStatusCode() == 404){
	             throw new FileNotFoundException(corelationId);
	         }
	         else{
	             throw exception;
	         }
	     }
	 }
	/* public URL uploadFile(MultipartFile file, String corelationid, String contentType) {
	        ObjectMetadata objectMetadata = new ObjectMetadata();
	        objectMetadata.setContentType(contentType);
	        objectMetadata.setContentLength(file.getSize());
	        //TODO add cache control
	        try {
	            s3client.putObject(bucketName, corelationid,file.getInputStream(), objectMetadata);
	        } catch(AmazonClientException |IOException exception) {
	            throw new RuntimeException("Error while uploading file.");
	        }
	        System.out.println("filelink: " + s3client.getUrl("your_bucket_name", "corelationid"));
	        return s3client.getUrl(bucketName, corelationid);
	    }
	*/
	public List<String> listFiles() {
		
	  ListObjectsRequest listObjectsRequest =  new ListObjectsRequest() .withBucketName(bucketName);
		
		List<String> keys = new ArrayList<>();
		
		ObjectListing objects = s3client.listObjects(listObjectsRequest);
		
		while (true) {
			List<S3ObjectSummary> summaries = objects.getObjectSummaries();
			if (summaries.size() < 1) {
				break;
			}
			
			for (S3ObjectSummary item : summaries) {
	            if (!item.getKey().endsWith("/"))
	            	keys.add(item.getKey());
	        }
			
			objects = s3client.listNextBatchOfObjects(objects);
		}
		
		return keys;
	}


}
	/*@Override
	public URL storeObjectInS3(MultipartFile file, String corelationId) {
		// TODO Auto-generated method stub
	
		        try {
		            s3client.getUrl(bucketName, corelationId);
		        } catch(AmazonClientException exception) {
		            throw new RuntimeException("Error while uploading file.");
		        }
		        return s3client.getUrl(bucketName, corelationId);
		    };
	} */

	 






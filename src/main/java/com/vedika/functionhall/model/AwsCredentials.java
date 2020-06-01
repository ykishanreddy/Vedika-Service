package com.vedika.functionhall.model;

import org.springframework.data.annotation.Id;

public class AwsCredentials{
	@Id
	private String id;
	private String awsId;
 
	private String awsKey;
	private String bucketName;
	
	private String region;
	 
	private long corelationId;
	
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBucketName() {
		return bucketName;
	}


	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}


	public String getAwsId() {
		return awsId;
	}


	public void setAwsId(String awsId) {
		this.awsId = awsId;
	}


	public String getAwsKey() {
		return awsKey;
	}


	public void setAwsKey(String awsKey) {
		this.awsKey = awsKey;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public long getCorelationId() {
		return corelationId;
	}


	public void setCorelationId(long corelationId) {
		this.corelationId = corelationId;
	}


	@Override
	public String toString() {
		return "AwsCredentials [id="+id+",awsId=" + awsId + ", awsKey=" + awsKey + ", bucketName=" + bucketName + ", region="
				+ region + ", corelationId=" + corelationId + "]";
	}


	
}



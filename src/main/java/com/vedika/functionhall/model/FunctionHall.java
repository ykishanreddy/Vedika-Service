package com.vedika.functionhall.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class FunctionHall {
	@Id
	private String id;

	private String name;
	private String ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	
    private String functionhallContactNumber;
	private String street;
	private String state;
	private String city;
	private int zipcode;
	private String email;
	private String bucketName;
	private String imageDirectoryPath;
	private String imageUrl;
	private long corelationId;
	
	public String getFunctionhallContactNumber() {
		return functionhallContactNumber;
	}
	public void setFunctionhallContactNumber(String functionhallContactNumber) {
		this.functionhallContactNumber = functionhallContactNumber;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getImageDirectoryPath() {
		return imageDirectoryPath;
	}
	public void setImageDirectoryPath(String imageDirectoryPath) {
		this.imageDirectoryPath = imageDirectoryPath;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCorelationId() {
		return corelationId;
	}
	public void setCorelationId(long corelationId) {
		this.corelationId = corelationId;
	}
	@Override
	public String toString() {
		return "FunctionHall [id=" + id + ", name=" + name + ", ownerId=" + ownerId + ", ownerFirstName="
				+ ownerFirstName + ", ownerLastName=" + ownerLastName + ", functionhallContactNumber="
				+ functionhallContactNumber + ", street=" + street + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", email=" + email + ", bucketName=" + bucketName + ", imageDirectoryPath="
				+ imageDirectoryPath + ", imageUrl=" + imageUrl + ", corelationId=" + corelationId + "]";
	}




	
}
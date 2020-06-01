package com.vedika.functionhall.model;

public class FunctionHallUIResponse {


	private String name;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerId;

	private String street;
	private String state;
	private String city;
	private int zipcode;
	private String email;
	private long corelationId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
		return "FunctionHallUIResponse [name=" + name + ", ownerFirstName=" + ownerFirstName + ", ownerLastName="
				+ ownerLastName + ", ownerId=" + ownerId + ", street=" + street + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", email=" + email + ", corelationId=" + corelationId + "]";
	}

}

package com.vedika.functionhall.model;

public class ResponsefindByNamefunctionhall {
	private String id;

	private String functionHallName;

	private String street;
	private String state;
	private String city;
	private int zipcode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFunctionHallName() {
		return functionHallName;
	}
	public void setFunctionHallName(String functionHallName) {
		this.functionHallName = functionHallName;
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
	@Override
	public String toString() {
		return "ResponsefindByNamefunctionhall [id=" + id + ", functionHallName=" + functionHallName + ", street="
				+ street + ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	


}

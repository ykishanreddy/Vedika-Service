package com.vedika.functionhall.model;

import org.springframework.data.annotation.Id;

public class FunctionHall {
  @Id
  private String id;

  	private String name;
  	private String ownerFirstName;
  	private String ownerLastName;

	private String street;
	private String state;
	private String city;
	private int zipcode;

  public FunctionHall() {

  }

public FunctionHall(String id, String name, String ownerFirstName, String ownerLastName, String street, String state,
		String city, int zipcode) {

	this.id = id;
	this.name = name;
	this.ownerFirstName = ownerFirstName;
	this.ownerLastName = ownerLastName;
	this.street = street;
	this.state = state;
	this.city = city;
	this.zipcode = zipcode;
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
	return "FunctionHall [id=" + id + ", name=" + name + ", ownerFirstName=" + ownerFirstName + ", ownerLastName="
			+ ownerLastName + ", street=" + street + ", state=" + state + ", city=" + city + ", zipcode=" + zipcode
			+ "]";
}





}
package com.vedika.functionhall.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class FunctionHall {
	@Id
	private String id;

	private String name;
	private long Contactno;

	private String street;
	private String state;
	private String city;
	private int zipcode;
	private String email;   
	private long corelationId;
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

	public long getContactno() {
		return Contactno;
	}
	public void setContactno(long contactno) {
		Contactno = contactno;
	}
	@Override
	public String toString() {
		return "FunctionHall [id=" + id + ", name=" + name + ", Contactno=" + Contactno + ", street=" + street
				+ ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + ", email=" + email
				+ ", corelationId=" + corelationId + "]";
	}

	
}
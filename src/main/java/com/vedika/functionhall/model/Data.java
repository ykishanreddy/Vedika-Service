package com.vedika.functionhall.model;

import java.util.List;

public class Data {

	private String country;
	private List<States> states;

	public String getCountry() {
		return country;

	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<States> getStates() {
		return states;
	}

	public void setStates(List<States> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Data [country=" + country + ", states=" + states + "]";
	}

}

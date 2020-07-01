package com.vedika.functionhall.model;

import java.util.List;

public class States {
	private String state;
	private List<String> cities;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "States [state=" + state + ", cities=" + cities + "]";
	}

}

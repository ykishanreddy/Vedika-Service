package com.vedika.functionhall.model;

public class StateResponse {

	private String id;
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StateResponse [id=" + id + ", data=" + data + "]";
	}

}

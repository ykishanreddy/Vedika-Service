package com.vedika.functionhall.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Regions")
public class Details {
	private String id;
	private Data data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", data=" + data + "]";
	}

}

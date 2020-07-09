package com.vedika.functionhall.model;

public class GenericResponse<T> {

    private String id;
    private T data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "GenericResponse [id=" + id + ", data=" + data + "]";
	}
	
    
}
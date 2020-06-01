package com.vedika.functionhall.model;

import java.util.List;

public class ResponseForCity {
	List<ResponsefindByCityfunctionhall> functionHalls;

	public List<ResponsefindByCityfunctionhall> getFunctionHalls() {
		return functionHalls;
	}

	public void setFunctionHalls(List<ResponsefindByCityfunctionhall> functionHalls) {
		this.functionHalls = functionHalls;
	}

	@Override
	public String toString() {
		return "ResponseForCity [functionHalls=" + functionHalls + ", getFunctionHalls()=" + getFunctionHalls()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}

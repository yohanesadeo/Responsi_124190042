package com.upnyk.covid.service.cases;

import com.google.gson.annotations.SerializedName;

public class CasesResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}
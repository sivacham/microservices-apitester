package com.verizon.apitester.model;

import java.util.HashMap;

public class RequestObj {

	private String requestType;
	private HashMap<String, Object> params;
	private String baseUrl;
	private HashMap<String, String> headers;
	private String authkey;
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}

	public String getAuthkey() {
		return authkey;
	}

	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}

	@Override
	public String toString() {
		return "RequestObj [requestType=" + requestType + ", params=" + params + ", baseUrl=" + baseUrl + ", headers="
				+ headers + ", authkey=" + authkey + "]";
	}
}

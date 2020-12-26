package com.verizon.apitester.model;

public class ResponseObj {

	private String status;
	private Object response;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseObj [status=" + status + ", response=" + response + "]";
	}

}

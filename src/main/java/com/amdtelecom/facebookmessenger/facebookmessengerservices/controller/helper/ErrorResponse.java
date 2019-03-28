package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

public class ErrorResponse {
	
	private int code;
	private String message;
	private String type; 
	private String status;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(int errorCode, String message) {
		this.code = errorCode;
		this.message = message;
		this.type = null;
		this.status = "failed";
	}

	public ErrorResponse(int errorCode, String message, String type, String status) {
		this.code = errorCode;
		this.message = message;
		this.type = type;
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int errorCode) {
		this.code = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

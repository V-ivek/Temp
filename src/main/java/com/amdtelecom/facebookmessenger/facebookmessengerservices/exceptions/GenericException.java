package com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions;

public class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3134619149673181869L;
	
	public static enum ERROR_CODE {
		NOT_FOUND(102), INCORRECT_FORMAT(111), ALREADY_PRESENT(101), MISSING_ELEMENT(100);
		
		private final int code;
		ERROR_CODE(int code) {
			this.code = code;
		}
		
		public int getIntegerCode() {
			return code;
		}
	};
	
	private ERROR_CODE code;
	private String type;
	
	public GenericException(ERROR_CODE code, String message, String type) {
		super(message);
		this.code = code;
		this.setType(type);
	}

	public ERROR_CODE getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

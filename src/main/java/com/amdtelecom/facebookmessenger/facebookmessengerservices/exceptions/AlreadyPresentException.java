package com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions;

public class AlreadyPresentException extends Exception {
	private String[] itemSetPresent;
	
	public AlreadyPresentException(String[] itemsSetPresent, String message) {
		super(message);
		this.itemSetPresent = itemsSetPresent;
	}
	
	public String[] getItemSetPresent() {
		return itemSetPresent;
	}
}

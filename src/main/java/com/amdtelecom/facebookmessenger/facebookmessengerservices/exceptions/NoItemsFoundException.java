package com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions;

public class NoItemsFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1121650503449078221L;
	
	private String[] items;

	public NoItemsFoundException(String[] items, String message) {
		super(message);
		this.items = items;
	}
	
	public NoItemsFoundException(String item, String message) {
		super(message);
		this.items = new String[] { item };
	}	
	
	public String[] getItems() {
		return items;
	}
}

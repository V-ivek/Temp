package com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions;

import java.util.Arrays;

public class MissingItemsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1919243333995758569L;
	
	private String items[];
	
	public MissingItemsException(String item, String message) {
		super(message);
		this.items = new String[] {item};
	}
	
	public MissingItemsException(String[] items, String message) {
		super(message);
		this.items = items;
	}

	public String[] getItems() {
		return items;
	}
	
	public String getItemsAsMessage() {
		return (this.items == null || items.length==0)?
				"items not set" : 
				(Arrays.toString(items)+" missing");
	}
}

package com.cg.exception;

public class PropertyNotFoundException extends Exception {
	/**
	 * @author Chiranjeevi Bhanu Teja Tatavarthi
	 *
	 * 
	 */
	private static final long serialVersionUID = -6321311880152203530L;
	String message;

	/**
	 * @param message
	 */
	public PropertyNotFoundException(String message) {
		super();
		this.message = message;
	}
}

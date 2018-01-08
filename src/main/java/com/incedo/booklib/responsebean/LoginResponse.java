/*
 * 
 */
package com.incedo.booklib.responsebean;
// TODO: Auto-generated Javadoc

/**
 * The Class LoginResponse.
 */
public class LoginResponse {
	
	/** The is authenticated. */
	private boolean isAuthenticated;
	
	/** The message. */
	private String message;

	/**
	 * Checks if is authenticated.
	 *
	 * @return true, if is authenticated
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	/**
	 * Sets the authenticated.
	 *
	 * @param isAuthenticated the new authenticated
	 */
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
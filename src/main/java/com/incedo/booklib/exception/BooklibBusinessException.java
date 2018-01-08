/*
 * 
 */
package com.incedo.booklib.exception;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class BooklibBusinessException.
 */
public class BooklibBusinessException extends Exception {

	/** The error map. */
	private HashMap<String, String> errorMap = new HashMap<String, String>();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new booklib business exception.
	 */
	public BooklibBusinessException() {
		super();
	}
	
	/**
	 * Instantiates a new booklib business exception.
	 *
	 * @param message the message
	 */
	public BooklibBusinessException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new booklib business exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public BooklibBusinessException(final String message, final Throwable exception) {
		super(message, exception);

	}

	/**
	 * Instantiates a new booklib business exception.
	 *
	 * @param exception the exception
	 */
	public BooklibBusinessException(final Throwable exception) {
		super(exception);
	}

	/**
	 * Sets the error map.
	 *
	 * @param errorMap the error map
	 */
	public void setErrorMap(HashMap<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	/**
	 * Gets the error map.
	 *
	 * @return the error map
	 */
	public HashMap<String, String> getErrorMap() {
		return errorMap;
	}

}
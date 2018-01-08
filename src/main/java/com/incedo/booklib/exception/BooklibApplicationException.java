/*
 * 
 */
package com.incedo.booklib.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class BooklibApplicationException.
 */
public class BooklibApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -761982813124377039L;

	/**
	 * Instantiates a new booklib application exception.
	 */
	public BooklibApplicationException() {
		super("There is some issue in our webservice, please reach out to our support team");
	}

	/**
	 * Instantiates a new booklib application exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public BooklibApplicationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new booklib application exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BooklibApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new booklib application exception.
	 *
	 * @param message the message
	 */
	public BooklibApplicationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new booklib application exception.
	 *
	 * @param cause the cause
	 */
	public BooklibApplicationException(Throwable cause) {
		super(cause);
	}

}
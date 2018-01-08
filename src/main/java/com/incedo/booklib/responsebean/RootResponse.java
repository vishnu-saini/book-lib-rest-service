/*
 * 
 */
package com.incedo.booklib.responsebean;

import com.incedo.booklib.constant.ResponseType;

// TODO: Auto-generated Javadoc
/**
 * The Class RootResponse.
 *
 * @param <T> the generic type
 */
public class RootResponse<T> {

	/** The status. */
	private ResponseType status;
	
	/** The data. */
	private T data;

	/**
	 * Instantiates a new root response.
	 */
	public RootResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new root response.
	 *
	 * @param status the status
	 * @param data the data
	 */
	public RootResponse(ResponseType status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ResponseType getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ResponseType status) {
		this.status = status;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RootResponse [status=" + status + ", data=" + data + "]";
	}

}

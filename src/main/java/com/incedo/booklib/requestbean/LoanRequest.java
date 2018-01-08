/*
 * 
 */
package com.incedo.booklib.requestbean;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanRequest.
 */
public class LoanRequest {

	/** The book id. */
	@NotNull(message = "error.book.isbn.null")
	private Integer bookId;

	/** The student id. */
	@NotNull(message = "error.student.id.null")
	private Integer studentId;

	/**
	 * Gets the book id.
	 *
	 * @return the book id
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * Sets the book id.
	 *
	 * @param bookId the new book id
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * Instantiates a new loan request.
	 *
	 * @param bookId the book id
	 * @param studentId the student id
	 */
	public LoanRequest(Integer bookId, Integer studentId) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
	}

	/**
	 * Instantiates a new loan request.
	 */
	public LoanRequest() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LendBookRequest [bookId=" + bookId + ", studentId=" + studentId + "]";
	}
}

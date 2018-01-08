/*
 * 
 */
package com.incedo.booklib.responsebean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.incedo.booklib.dto.Loan;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanBookResponse.
 */
public class LoanBookResponse {

	/** The isbn. */
	private int isbn;
	
	/** The name. */
	private String name;
	
	/** The category. */
	private String category;
	
	/** The publisher name. */
	private String publisherName;
	
	/** The date of issue. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateOfIssue;

	/**
	 * Instantiates a new loan book response.
	 */
	public LoanBookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new loan book response.
	 *
	 * @param loan the loan
	 */
	public LoanBookResponse(Loan loan) {
		super();
		this.isbn = loan.getBook().getIsbn();
		this.name = loan.getBook().getName();
		this.category = loan.getBook().getCategory().getName();
		this.publisherName = loan.getBook().getPublisher().getName();
		this.dateOfIssue = loan.getDateOfIssue();
	}

	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * Sets the isbn.
	 *
	 * @param isbn the new isbn
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the publisher name.
	 *
	 * @return the publisher name
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * Sets the publisher name.
	 *
	 * @param publisherName the new publisher name
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * Gets the date of issue.
	 *
	 * @return the date of issue
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * Sets the date of issue.
	 *
	 * @param dateOfIssue the new date of issue
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

}

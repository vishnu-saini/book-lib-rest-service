/*
 * 
 */
package com.incedo.booklib.responsebean;

import com.incedo.booklib.dto.Book;

// TODO: Auto-generated Javadoc
/**
 * The Class BookWithIssueCountResponse.
 */
public class BookWithIssueCountResponse {

	/** The isbn. */
	private int isbn;
	
	/** The name. */
	private String name;
	
	/** The category. */
	private String category;
	
	/** The publisher name. */
	private String publisherName;
	
	/** The assigned copies. */
	private int	assignedCopies;
	
	/** The unassigned copies. */
	private int	unassignedCopies;
	
	/**
	 * Instantiates a new book with issue count response.
	 */
	public BookWithIssueCountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new book with issue count response.
	 *
	 * @param book the book
	 * @param issueCount the issue count
	 */
	public BookWithIssueCountResponse(Book book,long issueCount) {
		super();
		this.isbn = book.getIsbn();
		this.name = book.getName();
		this.category = book.getCategory().getName();
		this.publisherName = book.getPublisher().getName();
		this.assignedCopies =(int) issueCount;
		this.unassignedCopies = book.getNumberOfBookAvailable();
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
	 * Gets the assigned copies.
	 *
	 * @return the assigned copies
	 */
	public int getAssignedCopies() {
		return assignedCopies;
	}
	
	/**
	 * Sets the assigned copies.
	 *
	 * @param assignedCopies the new assigned copies
	 */
	public void setAssignedCopies(int assignedCopies) {
		this.assignedCopies = assignedCopies;
	}
	
	/**
	 * Gets the unassigned copies.
	 *
	 * @return the unassigned copies
	 */
	public int getUnassignedCopies() {
		return unassignedCopies;
	}
	
	/**
	 * Sets the unassigned copies.
	 *
	 * @param unassignedCopies the new unassigned copies
	 */
	public void setUnassignedCopies(int unassignedCopies) {
		this.unassignedCopies = unassignedCopies;
	}
	
	

}

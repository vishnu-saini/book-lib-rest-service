/*
 * 
 */
package com.incedo.booklib.responsebean;

import java.util.ArrayList;
import java.util.List;

import com.incedo.booklib.dto.Book;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResponse.
 */
public class BookResponse {

	/** The number of books by author. */
	private int numberOfBooksByAuthor;
	
	/** The books. */
	private List<BookOfAuthor> books;

	/**
	 * Instantiates a new book response.
	 */
	public BookResponse() {
	}

	/**
	 * Instantiates a new book response.
	 *
	 * @param numberOfBooksByAuthor the number of books by author
	 * @param books the books
	 */
	public BookResponse(int numberOfBooksByAuthor, List<Book> books) {
		super();
		this.numberOfBooksByAuthor = numberOfBooksByAuthor;
		this.books = new ArrayList<BookOfAuthor>();
		for (Book book : books) {
			this.books.add(new BookOfAuthor(book));
		}
	}

	/**
	 * Gets the number of books by author.
	 *
	 * @return the number of books by author
	 */
	public int getNumberOfBooksByAuthor() {
		return numberOfBooksByAuthor;
	}

	/**
	 * Sets the number of books by author.
	 *
	 * @param numberOfBooksByAuthor the new number of books by author
	 */
	public void setNumberOfBooksByAuthor(int numberOfBooksByAuthor) {
		this.numberOfBooksByAuthor = numberOfBooksByAuthor;
	}

	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<BookOfAuthor> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 *
	 * @param books the new books
	 */
	public void setBooks(List<BookOfAuthor> books) {
		this.books = books;
	}
}

class BookOfAuthor {

	/** The isbn. */
	private int isbn;

	/** The name. */
	private String name;

	/** The category. */
	private String category;

	/** The no of books issued. */
	private int noOfBooksIssued;

	/** The no of books available. */
	private int noOfBooksAvailable;

	/** The publisher name. */
	private String publisherName;

	/**
	 * Instantiates a new book response.
	 *
	 * @param book
	 *            the book
	 */
	public BookOfAuthor(Book book) {
		this.isbn = book.getIsbn();
		this.name = book.getName();
		this.category = book.getCategory().getName();
		if (book.getLoans() == null)
			this.noOfBooksIssued = 0;
		else
			this.noOfBooksIssued = book.getLoans().size();
		this.noOfBooksAvailable = book.getNumberOfBookAvailable();
		this.publisherName = book.getPublisher().getName();

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
	 * @param isbn
	 *            the new isbn
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
	 * @param name
	 *            the new name
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
	 * @param category
	 *            the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the no of books issued.
	 *
	 * @return the no of books issued
	 */
	public int getNoOfBooksIssued() {
		return noOfBooksIssued;
	}

	/**
	 * Sets the no of books issued.
	 *
	 * @param noOfBooksIssued
	 *            the new no of books issued
	 */
	public void setNoOfBooksIssued(int noOfBooksIssued) {
		this.noOfBooksIssued = noOfBooksIssued;
	}

	/**
	 * Gets the no of books available.
	 *
	 * @return the no of books available
	 */
	public int getNoOfBooksAvailable() {
		return noOfBooksAvailable;
	}

	/**
	 * Sets the no of books available.
	 *
	 * @param noOfBooksAvailable
	 *            the new no of books available
	 */
	public void setNoOfBooksAvailable(int noOfBooksAvailable) {
		this.noOfBooksAvailable = noOfBooksAvailable;
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
	 * @param publisherName
	 *            the new publisher name
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
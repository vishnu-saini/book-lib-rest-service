/*
 * 
 */
package com.incedo.booklib.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;


// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 */
@Entity
@Table(name = "book")
public class Book {

	/** The isbn. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;

	/** The name. */
	private String name;

	/** The edision. */
	private String edision;

	/** The number of book available. */
	@Column(name = "number_of_book_available")
	private int numberOfBookAvailable;

	/** The category. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	/** The author. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;

	/** The publisher. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	/** The loans. */
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Loan> loans;

	/** The students. */
	@ManyToMany(mappedBy = "books")
	private List<Student> students;

	/**
	 * Gets the students.
	 *
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Sets the students.
	 *
	 * @param students the new students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Instantiates a new book.
	 */
	public Book() {
		super();
	}

	/**
	 * Instantiates a new book.
	 *
	 * @param isbn the isbn
	 */
	public Book(int isbn) {
		super();
		this.isbn = isbn;
	}

	/**
	 * Instantiates a new book.
	 *
	 * @param isbn
	 *            the isbn
	 * @param name
	 *            the name
	 * @param edision
	 *            the edision
	 * @param numberOfBookAvailable
	 *            the number of book available
	 */
	public Book(int isbn, String name, String edision, int numberOfBookAvailable) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.edision = edision;
		this.numberOfBookAvailable = numberOfBookAvailable;
	}

	/**
	 * Instantiates a new book.
	 *
	 * @param isbn
	 *            the isbn
	 * @param name
	 *            the name
	 * @param edision
	 *            the edision
	 * @param numberOfBookAvailable
	 *            the number of book available
	 * @param category
	 *            the category
	 * @param author
	 *            the author
	 * @param publisher
	 *            the publisher
	 */
	public Book(int isbn, String name, String edision, int numberOfBookAvailable, Category category, Author author,
			Publisher publisher) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.edision = edision;
		this.numberOfBookAvailable = numberOfBookAvailable;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
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
	 * Gets the edision.
	 *
	 * @return the edision
	 */
	public String getEdision() {
		return edision;
	}

	/**
	 * Sets the edision.
	 *
	 * @param edision
	 *            the new edision
	 */
	public void setEdision(String edision) {
		this.edision = edision;
	}

	/**
	 * Gets the number of book available.
	 *
	 * @return the number of book available
	 */
	public int getNumberOfBookAvailable() {
		return numberOfBookAvailable;
	}

	/**
	 * Sets the number of book available.
	 *
	 * @param numberOfBookAvailable
	 *            the new number of book available
	 */
	public void setNumberOfBookAvailable(int numberOfBookAvailable) {
		this.numberOfBookAvailable = numberOfBookAvailable;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category
	 *            the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author
	 *            the new author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * Gets the publisher.
	 *
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher.
	 *
	 * @param publisher
	 *            the new publisher
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the loans.
	 *
	 * @return the loans
	 */
	public List<Loan> getLoans() {
		return loans;
	}

	/**
	 * Sets the loans.
	 *
	 * @param loans
	 *            the new loans
	 */
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

}

/*
 * 
 */
package com.incedo.booklib.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;


// TODO: Auto-generated Javadoc
/**
 * The Class Loan.
 */
@Entity
@Table(name = "book_loan")
public class Loan {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The is returned. */
	private boolean isReturned;

	/** The date of issue. */
	private Date dateOfIssue;

	/** The student. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "student_id")
	@JsonManagedReference
	private Student student;

	/** The book. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "book_id")
	@JsonManagedReference
	private Book book;

	/** The loned by. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "loan_by_employee_id")
	@JsonManagedReference
	private Employee lonedBy;

	/**
	 * Instantiates a new loan.
	 */
	public Loan() {
		super();
	}

	/**
	 * Instantiates a new loan.
	 *
	 * @param isReturned the is returned
	 * @param dateOfIssue the date of issue
	 * @param student the student
	 * @param book the book
	 * @param lonedBy the loned by
	 */
	public Loan(boolean isReturned, Date dateOfIssue, Student student, Book book, Employee lonedBy) {
		super();
		this.isReturned = isReturned;
		this.dateOfIssue = dateOfIssue;
		this.student = student;
		this.book = book;
		this.lonedBy = lonedBy;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 *
	 * @param student
	 *            the new student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Gets the book.
	 *
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Sets the book.
	 *
	 * @param book
	 *            the new book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Gets the loned by.
	 *
	 * @return the loned by
	 */
	public Employee getLonedBy() {
		return lonedBy;
	}

	/**
	 * Sets the loned by.
	 *
	 * @param lonedBy
	 *            the new loned by
	 */
	public void setLonedBy(Employee lonedBy) {
		this.lonedBy = lonedBy;
	}

	/**
	 * Checks if is returned.
	 *
	 * @return true, if is returned
	 */
	public boolean isReturned() {
		return isReturned;
	}

	/**
	 * Sets the returned.
	 *
	 * @param isReturned the new returned
	 */
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Loan [id=" + id + ", isReturned=" + isReturned + ", dateOfIssue=" + dateOfIssue + ", student=" + student
				+ ", book=" + book + ", lonedBy=" + lonedBy + "]";
	}

}

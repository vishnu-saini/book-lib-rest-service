/*
 * 
 */
package com.incedo.booklib.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.incedo.booklib.dto.validation.group.StudentLoginValidationStep1;
import com.incedo.booklib.dto.validation.group.StudentLoginValidationStep2;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
@Table(name = "student")
public class Student {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The phone nubmer. */
	@Column(name = "phone_number")
	private String phoneNubmer;

	/** The email. */
	@Column(unique = true)
	@NotNull(message = "error.credential.not.found", groups = StudentLoginValidationStep1.class)
	@NotBlank(message = "error.credential.not.found", groups = StudentLoginValidationStep1.class)
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "error.student.email.notvalid", groups = StudentLoginValidationStep2.class)
	private String email;

	/** The password. */
	@NotNull(message = "error.credential.not.found", groups = StudentLoginValidationStep1.class)
	@NotBlank(message = "error.credential.not.found", groups = StudentLoginValidationStep1.class)
	private String password;
	
	
	/** The books. */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_loan", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "book_id") })
	private List<Book> books;
	

	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 *
	 * @param books the new books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 */
	public Student(int id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param id
	 *            the id
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param phoneNubmer
	 *            the phone nubmer
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 */
	public Student(int id, String firstName, String lastName, String phoneNubmer, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNubmer = phoneNubmer;
		this.email = email;
		this.password = password;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the phone nubmer.
	 *
	 * @return the phone nubmer
	 */
	public String getPhoneNubmer() {
		return phoneNubmer;
	}

	/**
	 * Sets the phone nubmer.
	 *
	 * @param phoneNubmer
	 *            the new phone nubmer
	 */
	public void setPhoneNubmer(String phoneNubmer) {
		this.phoneNubmer = phoneNubmer;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNubmer="
				+ phoneNubmer + ", email=" + email + ", password=" + password + "]";
	}

}

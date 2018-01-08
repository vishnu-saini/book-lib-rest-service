/*
 * 
 */
package com.incedo.booklib.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Author.
 */
@Entity
@Table(name="book_author")
public class Author {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The pen name. */
	@Column(name="pen_name")
	private String penName;
	
	/** The email. */
	private String email;
	
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
	 * @param id the new id
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
	 * @param firstName the new first name
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
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the pen name.
	 *
	 * @return the pen name
	 */
	public String getPenName() {
		return penName;
	}
	
	/**
	 * Sets the pen name.
	 *
	 * @param penName the new pen name
	 */
	public void setPenName(String penName) {
		this.penName = penName;
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
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", penName=" + penName
				+ ", email=" + email + "]";
	}
	
	/**
	 * Instantiates a new author.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param penName the pen name
	 * @param email the email
	 */
	public Author(int id, String firstName, String lastName, String penName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.penName = penName;
		this.email = email;
	}
	
	/**
	 * Instantiates a new author.
	 */
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

}

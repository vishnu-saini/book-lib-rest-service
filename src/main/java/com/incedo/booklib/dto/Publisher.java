/*
 * 
 */
package com.incedo.booklib.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class Publisher.
 */
@Entity
@Table(name="publisher")
public class Publisher {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** The name. */
	private String name;
	
	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
	
	/**
	 * Instantiates a new publisher.
	 */
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new publisher.
	 *
	 * @param id the id
	 * @param name the name
	 * @param creationDate the creation date
	 */
	public Publisher(int id, String name, Date creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
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
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", creationDate=" + creationDate + "]";
	}
	
	
	
}

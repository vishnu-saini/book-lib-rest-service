/*
 * 
 */
package com.incedo.booklib.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Category.
 */
@Entity
@Table(name="book_category")
public class Category {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new category.
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new category.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}

/*
 * 
 */
package com.incedo.booklib.responsebean;

import java.util.ArrayList;
import java.util.List;

import com.incedo.booklib.dto.Book;
import com.incedo.booklib.dto.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResponse.
 */
public class StudentResponse {


	/** The books. */
	private List<StudentForResponse> students;

	/**
	 * Instantiates a new book response.
	 */
	public StudentResponse() {
	}

	/**
	 * Instantiates a new book response.
	 *
	 * @param numberOfBooksByAuthor the number of books by author
	 * @param books the books
	 */
	public StudentResponse(List<Student> students) {
		super();
		this.students = new ArrayList<StudentForResponse>();
		for ( Student student : students) {
			this.students.add(new StudentForResponse(student));
		}
	}



	public List<StudentForResponse> getStudents() {
		return students;
	}

	public void setStudents(List<StudentForResponse> students) {
		this.students = students;
	}
}

class StudentForResponse {

	private int id;

	private String firstName;

	private String lastName;

	private String phoneNubmer;

	private String email;

	private String password;
	
	private List<Book> books;
	

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public StudentForResponse() {
		super();
	}
	public StudentForResponse(int id) {
		super();
		this.id = id;
	}
	public StudentForResponse(Student student) {
		super();
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.phoneNubmer = student.getPhoneNubmer();
		this.email = student.getEmail();
		this.password = student.getPassword();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNubmer() {
		return phoneNubmer;
	}

	public void setPhoneNubmer(String phoneNubmer) {
		this.phoneNubmer = phoneNubmer;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNubmer="
				+ phoneNubmer + ", email=" + email + ", password=" + password + "]";
	}


}
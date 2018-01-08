/*
 * 
 */
package com.incedo.booklib.service;

import com.incedo.booklib.aspect.Loggable;
import com.incedo.booklib.dto.Student;
import com.incedo.booklib.exception.BooklibBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Adds the student.
	 *
	 * @param student the student
	 * @return the student
	 */
	@Loggable
	public Student addStudent(Student student);

	/**
	 * Authenticate student.
	 *
	 * @param student the student
	 * @return true, if successful
	 * @throws BooklibBusinessException the booklib business exception
	 */
	@Loggable
	public boolean authenticateStudent(Student student) throws BooklibBusinessException;

}

/*
 * 
 */
package com.incedo.booklib.service;

import java.util.List;

import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.responsebean.LoanBookResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoanService.
 */
public interface LoanService {

	/**
	 * Checks if is sue book.
	 *
	 * @param isbn the isbn
	 * @param studentId the student id
	 * @return true, if is sue book
	 * @throws BooklibBusinessException the booklib business exception
	 */
	public boolean issueBook(int isbn, int studentId) throws BooklibBusinessException;

	/**
	 * Deposit book.
	 *
	 * @param isbn the isbn
	 * @param studentId the student id
	 * @return true, if successful
	 * @throws BooklibBusinessException the booklib business exception
	 */
	public boolean depositBook(int isbn, int studentId) throws BooklibBusinessException;

	/**
	 * Gets the issued book of student.
	 *
	 * @param studentId the student id
	 * @return the issued book of student
	 * @throws BooklibBusinessException the booklib business exception
	 */
	public List<LoanBookResponse> getIssuedBookOfStudent(int studentId) throws BooklibBusinessException;

}

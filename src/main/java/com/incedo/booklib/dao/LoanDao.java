/*
 * 
 */
package com.incedo.booklib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.incedo.booklib.constant.QueryConstant;
import com.incedo.booklib.dto.Loan;

// TODO: Auto-generated Javadoc
/**
 * The Interface AuthorDao.
 */
@Repository
public interface LoanDao extends JpaRepository<Loan, Integer> {

	/**
	 * Find issued loan by student id and book id.
	 *
	 * @param studentId the student id
	 * @param bookId the book id
	 * @return the list
	 */
	@Query(value = QueryConstant.FIND_ISSUED_LOAN_BY_STUDENT_AND_BOOK_ID)
	public List<Loan> findIssuedLoanByStudentIdAndBookId(@Param("studentId") int studentId, @Param("bookId") int bookId);

	/**
	 * Find issued loan by student id.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	@Query(value = QueryConstant.FIND_ISSUED_LOAN_BY_STUDENT)
	public List<Loan> findIssuedLoanByStudentId(@Param("studentId") int studentId);
	
	/**
	 * Count book issued to student.
	 *
	 * @param studentId the student id
	 * @return the int
	 */
	@Query(value = QueryConstant.COUNT_BOOK_ISSUED_TO_STUDENT)
	public int countBookIssuedToStudent(@Param("studentId") int studentId);

}
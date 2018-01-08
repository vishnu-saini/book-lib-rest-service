/*
 * 
 */
package com.incedo.booklib.constant;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryConstant.
 */
public class QueryConstant {
	
	/** The Constant FIND_BOOK_BY_AUTHOR. */
	public static final String FIND_BOOK_BY_AUTHOR = "SELECT b FROM Book b  WHERE b.author.id = :authorid";
	
	/** The Constant COUNT_BOOK_BY_AUTHOR. */
	public static final String COUNT_BOOK_BY_AUTHOR = "SELECT COUNT(b) FROM Book b WHERE b.author.id = :authorid";
	
	/** The Constant FIND_STUDENT_BY_EMAIL. */
	public static final String FIND_STUDENT_BY_EMAIL = "FROM Student WHERE email = :email";
	
	/** The Constant FIND_ISSUED_LOAN_BY_STUDENT_AND_BOOK_ID. */
	public static final String FIND_ISSUED_LOAN_BY_STUDENT_AND_BOOK_ID = "FROM Loan l WHERE l.student.id = :studentId AND l.book.isbn = :bookId and l.isReturned = false";
	
	/** The Constant FIND_ISSUED_LOAN_BY_STUDENT. */
	public static final String FIND_ISSUED_LOAN_BY_STUDENT = "FROM Loan l WHERE l.student.id = :studentId AND l.isReturned = false";
	
	/** The Constant COUNT_BOOK_ISSUED_TO_STUDENT. */
	public static final String COUNT_BOOK_ISSUED_TO_STUDENT = "SELECT COUNT(l) FROM Loan l WHERE l.student.id = :studentId AND l.isReturned = false";

	/** The Constant BOOK_LIST_WITH_ASSIGNED_COUNT. */
	public static final String BOOK_LIST_WITH_ASSIGNED_COUNT = "select new com.incedo.booklib.responsebean.BookWithIssueCountResponse(b,count(l)) from Book b left join b.loans l where l.isReturned = false or l.isReturned is null group by b";
}



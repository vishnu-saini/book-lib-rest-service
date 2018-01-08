/*
 * 
 */
package com.incedo.booklib.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.incedo.booklib.dao.BookDao;
import com.incedo.booklib.dao.LoanDao;
import com.incedo.booklib.dao.StudentDao;
import com.incedo.booklib.dto.Book;
import com.incedo.booklib.dto.Employee;
import com.incedo.booklib.dto.Loan;
import com.incedo.booklib.dto.Student;
import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.responsebean.LoanBookResponse;
import com.incedo.booklib.service.LoanService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanServiceImpl.
 */
@Service
@Transactional
public class LoanServiceImpl implements LoanService {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The student dao. */
	@Autowired
	StudentDao studentDao;

	/** The book dao. */
	@Autowired
	BookDao bookDao;

	/** The loan dao. */
	@Autowired
	LoanDao loanDao;
	
	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.LoanService#issueBook(int, int)
	 */
	@Override
	public boolean issueBook(int isbn, int studentId) throws BooklibBusinessException {

		boolean result = false;
		
		Student student = checkStudentExist(studentId);
		Book book = checkBookExist(isbn);
			
		if (loanDao.countBookIssuedToStudent(studentId) >= 5) {
			throw new BooklibBusinessException(messageSource.getMessage("error.loan.book.max_issued", null, Locale.US));
		}
		
		if(book.getNumberOfBookAvailable() <= 0){
			throw new BooklibBusinessException(messageSource.getMessage("error.book.notavailable", null, Locale.US));
		}else{
			book.setNumberOfBookAvailable(book.getNumberOfBookAvailable() - 1);
		}
		
		Loan loan = new Loan(false, new Date(), student, book, new Employee(1));
		loanDao.save(loan);

		if (loan.getId() > 0)
			result = true;

		return result;
	}

	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.LoanService#depositBook(int, int)
	 */
	@Override
	public boolean depositBook(int isbn, int studentId) throws BooklibBusinessException {

		List<Loan> loans = null;
		boolean result = false;

		checkStudentExist(studentId);
		Book book = checkBookExist(isbn);

		loans = loanDao.findIssuedLoanByStudentIdAndBookId(studentId, isbn);
		
		if (loans.size() > 0) {
			Loan loan = loans.get(0);
			loan.setReturned(true);
			book.setNumberOfBookAvailable(book.getNumberOfBookAvailable() + 1);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.LoanService#getIssuedBookOfStudent(int)
	 */
	@Override
	public List<LoanBookResponse> getIssuedBookOfStudent(int studentId) throws BooklibBusinessException {
		List<Loan> loans;
		List<LoanBookResponse> bookResponses = new ArrayList<>();
		checkStudentExist(studentId);
		loans = loanDao.findIssuedLoanByStudentId(studentId);
		loans.forEach(loan -> bookResponses.add(new LoanBookResponse(loan)));
		return bookResponses;
	}

	/**
	 * Check student exist.
	 *
	 * @param studentId the student id
	 * @return the student
	 * @throws BooklibBusinessException the booklib business exception
	 */
	public Student checkStudentExist(int studentId) throws BooklibBusinessException {
		Student student = studentDao.findOne(studentId);
		if (student == null) {
			throw new BooklibBusinessException(messageSource.getMessage("error.student.notexist", null, Locale.US));
		}
		return student;
	}

	/**
	 * Check book exist.
	 *
	 * @param isbn the isbn
	 * @return the book
	 * @throws BooklibBusinessException the booklib business exception
	 */
	public Book checkBookExist(int isbn) throws BooklibBusinessException {
		Book book = bookDao.findOne(isbn);
		if (book == null) {
			throw new BooklibBusinessException(messageSource.getMessage("error.book.notexist", null, Locale.US));
		}
		return book;
	}

	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.LoanService#test()
	 */
	@Override
	public void test() {
		System.out.println(studentDao.findOne(1).getBooks());
	}
}

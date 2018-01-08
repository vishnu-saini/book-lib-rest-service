/*
 * 
 */
package com.incedo.booklib.service.Impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.booklib.aspect.Loggable;
import com.incedo.booklib.dao.AuthorDao;
import com.incedo.booklib.dao.BookDao;
import com.incedo.booklib.dto.Book;
import com.incedo.booklib.exception.BooklibApplicationException;
import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.responsebean.BookResponse;
import com.incedo.booklib.responsebean.BookWithIssueCountResponse;
import com.incedo.booklib.service.BookService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookServiceImpl.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	/** The book dao. */
	@Autowired
	BookDao bookDao;

	/** The message source. */
	@Autowired
	MessageSource messageSource;

	/** The author dao. */
	@Autowired
	AuthorDao authorDao;

	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.BookService#getAllBooks()
	 */
	@Override
	@Loggable
	@Transactional(readOnly = true)
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.incedo.booklib.service.BookService#getAllBookAndAssignCount()
	 */
	@Override
	@Loggable
	@Transactional(readOnly = true)
	public List<BookWithIssueCountResponse> getAllBookAndAssignCount() {
		List<BookWithIssueCountResponse> books = bookDao.getBooksWithAssignCount();
		return books;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.incedo.booklib.service.BookService#findBooksByAuthor(int, int,
	 * int)
	 */
	@Override
	@Loggable
	@Transactional(readOnly = true)
	public BookResponse findBooksByAuthor(int authorId, int limit, int page)
			throws BooklibApplicationException, BooklibBusinessException {
		if (page <= 0) {
			throw new BooklibBusinessException(
					messageSource.getMessage("error.book.page_number_less_0", null, Locale.US));
		} else if (limit <= 0) {
			throw new BooklibBusinessException(
					messageSource.getMessage("error.book.onpage_book_limit_less_0", null, Locale.US));
		} else if (!authorDao.exists(authorId)) {
			throw new BooklibBusinessException(
					messageSource.getMessage("error.book.author_not_exist", null, Locale.US));
		}

		// page=page-1; because of pages in spring data strats from 0
		List<Book> books = bookDao.findBooksByAuthorId(authorId, new PageRequest(page - 1, limit));
		int noOfBooksByAuthor = bookDao.countBooksByAuthorId(authorId);
		return new BookResponse(noOfBooksByAuthor, books);
	}

	@Override
	public Book addBook(Book book) {
		return bookDao.save(book);
	}
}

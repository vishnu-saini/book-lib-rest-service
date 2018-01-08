/*
 * 
 */
package com.incedo.booklib.service;

import java.util.List;

import com.incedo.booklib.dto.Book;
import com.incedo.booklib.exception.BooklibApplicationException;
import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.responsebean.BookResponse;
import com.incedo.booklib.responsebean.BookWithIssueCountResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookService.
 */
public interface BookService {

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	List<Book> getAllBooks();

	/**
	 * Find books by author.
	 *
	 * @param authorId
	 *            the author id
	 * @param limit
	 *            the limit
	 * @param page
	 *            the page
	 * @return the book response
	 * @throws BooklibBusinessException
	 *             the booklib business exception
	 * @throws BooklibApplicationException
	 *             the booklib application exception
	 */
	public BookResponse findBooksByAuthor(int authorId, int limit, int page)
			throws BooklibBusinessException, BooklibApplicationException;

	/**
	 * Gets the all book and assign count.
	 *
	 * @return the all book and assign count
	 */
	public List<BookWithIssueCountResponse> getAllBookAndAssignCount();
	
	
	public Book addBook(Book book);

}

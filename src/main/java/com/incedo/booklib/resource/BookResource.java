/*
 * 
 */
package com.incedo.booklib.resource;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.dto.Book;
import com.incedo.booklib.requestbean.LoanRequest;
import com.incedo.booklib.responsebean.BookResponse;
import com.incedo.booklib.responsebean.BookWithIssueCountResponse;
import com.incedo.booklib.responsebean.RootResponse;
import com.incedo.booklib.service.BookService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResource.
 */
@CrossOrigin
@RestController
@RequestMapping("api/book")
public class BookResource {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(BookResource.class);

	/** The book service. */
	@Autowired
	private BookService bookService;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Gets the all books.
	 *
	 * @param page
	 *            the page
	 * @param limit
	 *            the limit
	 * @param authorId
	 *            the author id
	 * @return the all books
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.GET, params = { "page", "limit",
			"authorid" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<BookResponse> getBooksForPagination(@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			@RequestParam("authorid") int authorId) throws Exception {
		logger.debug("page : " + page + "; limit : " + limit + "; authorid : " + authorId);
		return new RootResponse<BookResponse>(ResponseType.SUCCESS,
				bookService.findBooksByAuthor(authorId, limit, page));
	}

	/**
	 * Gets the all books with available count.
	 *
	 * @return the all books with available count
	 * @throws Exception
	 *             the exception
	 */
	/*@RequestMapping(method = RequestMethod.GET, params = {}, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<BookWithIssueCountResponse>> getAllBooksWithAvailableCount() throws Exception {
		return new RootResponse<List<BookWithIssueCountResponse>>(ResponseType.SUCCESS,
				bookService.getAllBookAndAssignCount());
	}*/

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> issueBook(@Valid @RequestBody Book book) throws Exception {

		bookService.addBook(book);
		return new RootResponse<String>(ResponseType.SUCCESS,
				messageSource.getMessage("success.loan.issue", null, Locale.US));

	}
	
	
	@RequestMapping(value="/all",method = RequestMethod.GET, params = {}, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<Book>> getAllBooks() throws Exception {
		return new RootResponse<List<Book>>(ResponseType.SUCCESS,
				bookService.getAllBooks());
	}

}

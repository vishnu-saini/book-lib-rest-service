/*
 * 
 */
package com.incedo.booklib.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.incedo.booklib.constant.QueryConstant;
import com.incedo.booklib.dto.Book;
import com.incedo.booklib.responsebean.BookWithIssueCountResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookDao.
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

	/**
	 * Find books by author id.
	 *
	 * @param authorId the author id
	 * @param pageable the pageable
	 * @return the list
	 */
	@Query(value=QueryConstant.FIND_BOOK_BY_AUTHOR)
	public List<Book> findBooksByAuthorId(@Param("authorid") int authorId, Pageable pageable);
	
	/**
	 * Count books by author id.
	 *
	 * @param authorId the author id
	 * @return the int
	 */
	@Query(value=QueryConstant.COUNT_BOOK_BY_AUTHOR)
	public int countBooksByAuthorId(@Param("authorid") int authorId);
	
	/**
	 * Gets the books with assign count.
	 *
	 * @return the books with assign count
	 */
	@Query(value=QueryConstant.BOOK_LIST_WITH_ASSIGNED_COUNT)
	public List<BookWithIssueCountResponse> getBooksWithAssignCount();
}
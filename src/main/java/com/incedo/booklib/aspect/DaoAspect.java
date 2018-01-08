/*
 * 
 */
package com.incedo.booklib.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.incedo.booklib.exception.BooklibApplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class DaoAspect.
 */
@Component
@Aspect
public class DaoAspect {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(DaoAspect.class);

	/**
	 * Do recovery actions.
	 *
	 * @param dataAccessException the data access exception
	 * @throws BooklibApplicationException the booklib application exception
	 */
	@AfterThrowing(pointcut = "within(com.incedo.booklib.service..*)", throwing = "dataAccessException")
	public void doRecoveryActions(DataAccessException dataAccessException) throws BooklibApplicationException {
		logger.debug(dataAccessException.getStackTrace().toString());
		System.out.println("hi I am in daoaspect");
		throw new BooklibApplicationException();
	}

}
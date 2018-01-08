/*
 * 
 */
package com.incedo.booklib.exceptionhandler;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.incedo.booklib.aspect.Loggable;
import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.exception.BooklibApplicationException;
import com.incedo.booklib.exception.BooklibBusinessException;
import com.incedo.booklib.responsebean.ErrorResponse;
import com.incedo.booklib.responsebean.RootResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class RestResponseEntityExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/** The message source. */
	@Autowired
	MessageSource messageSource;

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Exception handler.
	 *
	 * @param booklibBusinessException the booklib business exception
	 * @return the response entity
	 */
	@ExceptionHandler(BooklibBusinessException.class)
	public ResponseEntity<RootResponse<ErrorResponse>> exceptionHandler(
			BooklibBusinessException booklibBusinessException) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(booklibBusinessException.getMessage());
		RootResponse<ErrorResponse> rootResponse = new RootResponse<ErrorResponse>(ResponseType.ERROR, error);
		return new ResponseEntity<RootResponse<ErrorResponse>>(rootResponse, HttpStatus.PRECONDITION_FAILED);
	}

	/**
	 * Request handling no handler found.
	 *
	 * @param noHandlerFoundException
	 *            the no handler found exception
	 * @return the response entity
	 */
	@Loggable
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorResponse> requestHandlingNoHandlerFound(
			NoHandlerFoundException noHandlerFoundException) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(messageSource.getMessage("error.bad.url", null, Locale.US));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Application exception handler.
	 *
	 * @param booklibApplicationException
	 *            the booklib application exception
	 * @return the response entity
	 */
	@Loggable
	@ExceptionHandler(value = { BooklibApplicationException.class })
	public ResponseEntity<ErrorResponse> applicationExceptionHandler(
			BooklibApplicationException booklibApplicationException) {
		logger.error("Error while processing :", booklibApplicationException);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(booklibApplicationException.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle missing params.
	 *
	 * @param missingServletRequestParameterException the missing servlet request parameter exception
	 * @return the response entity
	 */
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseEntity<RootResponse<ErrorResponse>> handleMissingParams(
			MissingServletRequestParameterException missingServletRequestParameterException) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(messageSource.getMessage("error.validation.parameter.missing",
				new String[] { missingServletRequestParameterException.getParameterName() }, Locale.US));
		RootResponse<ErrorResponse> rootResponse = new RootResponse<ErrorResponse>(ResponseType.ERROR, error);
		return new ResponseEntity<RootResponse<ErrorResponse>>(rootResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle missing params.
	 *
	 * @param typeMismatchException the type mismatch exception
	 * @return the response entity
	 */
	@ExceptionHandler({ TypeMismatchException.class })
	public ResponseEntity<RootResponse<ErrorResponse>> handleMissingParams(
			TypeMismatchException typeMismatchException) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(messageSource.getMessage("error.validation.parameter.typemissmatch", null, Locale.US));
		RootResponse<ErrorResponse> rootResponse = new RootResponse<ErrorResponse>(ResponseType.ERROR, error);
		return new ResponseEntity<RootResponse<ErrorResponse>>(rootResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle http message not readable exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<RootResponse<ErrorResponse>> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException ex) {
		ErrorResponse error = new ErrorResponse();

		if (ex.getCause() instanceof JsonMappingException) {
			JsonMappingException jme = (JsonMappingException) ex.getCause();
			error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
			if (jme.getPath().size() > 0) {
				error.setMessage(messageSource.getMessage("error.input.invalid",
						new String[] { jme.getPath().get(0).getFieldName() }, Locale.US));
			} else {
				error.setMessage(messageSource.getMessage("error.validation.input.notavailable", null, Locale.US));
			}
		} else if (ex.getCause() instanceof JsonParseException) {
			error.setMessage(messageSource.getMessage("error.validation.input.json.invalid", null, Locale.US));
		} else {
			error.setMessage(messageSource.getMessage("error.validation.input", null, Locale.US));
		}

		RootResponse<ErrorResponse> rootResponse = new RootResponse<ErrorResponse>(ResponseType.ERROR, error);
		return new ResponseEntity<RootResponse<ErrorResponse>>(rootResponse, HttpStatus.PRECONDITION_FAILED);

	}

	/**
	 * Exception handler.
	 *
	 * @param exception
	 *            the exception
	 * @return the response entity
	 */
	@Loggable
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {
		logger.error("Error while processing :", exception);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(messageSource.getMessage("error.server.error", null, Locale.US));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
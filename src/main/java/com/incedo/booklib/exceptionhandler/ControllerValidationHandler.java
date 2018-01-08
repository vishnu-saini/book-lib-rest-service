/*
 * 
 */
package com.incedo.booklib.exceptionhandler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.responsebean.ErrorResponse;
import com.incedo.booklib.responsebean.RootResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerValidationHandler.
 */
@ControllerAdvice
public class ControllerValidationHandler {
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Process validation error.
	 *
	 * @param ex the ex
	 * @return the root response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public RootResponse<ErrorResponse> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
		return processFieldError(error);
	}

	/**
	 * Process field error.
	 *
	 * @param error the error
	 * @return the root response
	 */
	private RootResponse<ErrorResponse> processFieldError(FieldError error) {
		RootResponse<ErrorResponse> rootResponse = null;
		if (error != null) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			String message = messageSource.getMessage(error.getDefaultMessage(), null, currentLocale);
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
			errorResponse.setMessage(message);
			rootResponse = new RootResponse<ErrorResponse>(ResponseType.ERROR, errorResponse);
		}
		return rootResponse;
	}
}
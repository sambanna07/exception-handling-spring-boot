package com.exceptionhandler.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exceptionhandler.exception.EmptyInputException;
import com.exceptionhandler.exception.EmptyOutputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * Handles EmptyOutputException and returns an appropriate response entity with
	 * error message and HTTP status code.
	 * 
	 * @param emptyOutputException the EmptyOutputException to handle
	 * @return ResponseEntity<String> containing the error message and HTTP status
	 *         code
	 */
	@ExceptionHandler(EmptyOutputException.class)
	public ResponseEntity<String> handleEmptyOutputException(EmptyOutputException emptyOutputException) {

		return new ResponseEntity<>(emptyOutputException.getErrorMessage(), HttpStatusCode.valueOf(emptyOutputException.getErrorCode()));
	}

	/**
	 * Handles NoSuchElementException and returns an appropriate response entity
	 * with error message and HTTP status code.
	 * 
	 * @param noSuchElementException the NoSuchElementException to handle
	 * @return ResponseEntity<String> containing the error message and HTTP status
	 *         code
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		return new ResponseEntity<>(noSuchElementException.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles EmptyInputException and returns an appropriate response entity with
	 * error message and HTTP status code.
	 * 
	 * @param emptyInputException the EmptyInputException to handle
	 * @return ResponseEntity<String> containing the error message and HTTP status
	 *         code
	 */
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException) {
		return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatusCode.valueOf(emptyInputException.getErrorCode()));
	}

	/**
	 * Handles HttpRequestMethodNotSupportedException and returns an appropriate
	 * response entity with error message and HTTP status code.
	 * 
	 * @param ex      the HttpRequestMethodNotSupportedException to handle
	 * @param headers the HttpHeaders of the request
	 * @param request the WebRequest
	 * @return ResponseEntity<Object> containing the error message and HTTP status
	 *         code
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<>("You are using the wrong method for sending the request. Please select the correct method.",
				HttpStatus.BAD_REQUEST);
	}

}

package com.capgemini.flight.exceptions;

public class ValidateException extends Exception {

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ValidateException(String message) {
		super(message);
		
	}

}

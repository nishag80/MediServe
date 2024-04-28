package com.edu.exception;

public class SystemException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final ErrorType errorType;

	public SystemException(ErrorType errorType, Throwable cause, String message) {
		super(message, cause);
		this.errorType = errorType;
	}

	public SystemException(ErrorType errorType, String message) {
		super(message);
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

}

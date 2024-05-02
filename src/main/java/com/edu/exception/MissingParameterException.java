package com.edu.exception;

public class MissingParameterException  extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingParameterException(String parameterName) {
        super("Parameter '" + parameterName + "' is missing.");
    }
}

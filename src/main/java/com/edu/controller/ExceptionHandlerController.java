package com.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edu.exception.MissingParameterException;
import com.edu.exception.SystemException;
import com.edu.utility.ApiResponse;
import com.edu.utility.StatusType;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(SystemException.class)
	public ResponseEntity<ApiResponse> handleSystemException(SystemException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse(ex.getErrorType().getCode(), ex.getMessage(), null));
	}
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiResponse> handleOtherExceptions(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ApiResponse(StatusType.INTERNAL_ERROR.getName(), ex.getMessage(), null));
	    }
	 
	 @ExceptionHandler(MissingParameterException.class)
	    public ResponseEntity<ApiResponse> handleMissingParameterException(MissingParameterException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ApiResponse(StatusType.MISSING_PARAM.getName(), ex.getMessage(), null));
	    }

}

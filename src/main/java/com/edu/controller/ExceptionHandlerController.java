package com.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edu.exception.ErrorResponse;
import com.edu.exception.MissingParameterException;
import com.edu.exception.SystemException;
import com.edu.utility.ApiResponse;
import com.edu.utility.StatusType;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<ErrorResponse> handleSystemException(SystemException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorType().getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    
    @ExceptionHandler(MissingParameterException.class)
    public ResponseEntity<?> handleMissingParameterException(MissingParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(StatusType.MISSING_PARAM.getName(), ex.getMessage(), null));
    }

}

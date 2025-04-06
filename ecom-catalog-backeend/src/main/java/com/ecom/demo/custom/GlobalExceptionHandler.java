package com.ecom.demo.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handles ProductNotFoundException and returns a 404 response.
     *
     * @param ex the ProductNotFoundException
     * @return a ResponseEntity with error details
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        log.error("Product not found: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Product Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(CategoryNotFoundException ex) {
        log.error("Categories not found: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Categories Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    

    /**
     * Handles all other exceptions and returns a 500 response.
     *
     * @param ex the Exception
     * @return a ResponseEntity with error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("An unexpected error occurred: {}", ex.getMessage(), ex);
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Handles IllegalArgumentException and returns a 400 response.
     *
     * @param ex the IllegalArgumentException
     * @return a ResponseEntity with error details
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Invalid argument: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Bad Request", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    /**
     * Handles NullPointerException and returns a 500 response.
     *
     * @param ex the NullPointerException
     * @return a ResponseEntity with error details
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
        log.error("Null pointer exception: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", "A null value was encountered.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

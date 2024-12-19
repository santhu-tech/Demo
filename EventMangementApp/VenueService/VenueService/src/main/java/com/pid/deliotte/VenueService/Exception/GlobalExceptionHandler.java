package com.pid.deliotte.VenueService.Exception;

import com.pid.deliotte.VenueService.Model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VenueNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleVenueNotFoundException(VenueNotFoundException ex) {
        ApiResponse<Object> response = new ApiResponse<>("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VenueAvailabilityNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleVenueAvailabilityException(VenueAvailabilityNotFoundException ex) {
        ApiResponse<Object> response = new ApiResponse<>("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        ApiResponse<Object> response = new ApiResponse<>("ERROR", "An unexpected error occurred: " + ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.elk.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vikrant_Gopewar on 31-07-2023
 * @Project SpringBoot_E_L_K
 */

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, List<String>> errors = new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMessage = getBriefErrorMessage(fieldError); // Call a separate method to get a brief error message
            errors.computeIfAbsent(fieldName, key -> new ArrayList<>()).add(errorMessage);
        }
        ApiValidationErrorResponse apiValidationErrorResponse = ApiValidationErrorResponse.builder()
                .status(false)
                .error("Validation failed")
                .message("Validation error(s) occurred")
                .errorNumber(1458974)
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();
        log.error("handleValidationException : {} ",ex.getMessage());
        return ResponseEntity.badRequest().body(apiValidationErrorResponse);
    }


    private String getBriefErrorMessage(FieldError fieldError) {
        String defaultMessage = fieldError.getDefaultMessage();
        String[] parts = defaultMessage.split("\\{");
        return parts[0].trim();
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .status(false)
                .error("Bad request")
                .message(ex.getMessage())
                .errorNumber(1458973)
                .timestamp(LocalDateTime.now())
                .build();
        log.error("handleIllegalArgumentException : {} ",ex.getMessage());
        return ResponseEntity.badRequest().body(apiErrorResponse);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .status(false)
                .error("Method Not Allowed")
                .message(ex.getMessage())
                .errorNumber(1458973)
                .timestamp(LocalDateTime.now())
                .build();
        log.error("handleHttpRequestMethodNotSupportedException : {} ",ex.getMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(apiErrorResponse);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .status(false)
                .error("RuntimeException")
                .message(ex.getMessage())
                .errorNumber(1458972)
                .timestamp(LocalDateTime.now())
                .build();
        log.error("handleRuntimeException : {} ",ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiErrorResponse);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(Exception ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .status(false)
                .error("Internal Server Error")
                .message(ex.getMessage())
                .errorNumber(1458971)
                .timestamp(LocalDateTime.now())
                .build();
        log.error("handleException : {} ",ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }
}
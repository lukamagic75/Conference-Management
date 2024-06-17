package com.example.newconferencemanagement.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static <T> ResponseEntity<T> createResponse(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity<String> createErrorResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}

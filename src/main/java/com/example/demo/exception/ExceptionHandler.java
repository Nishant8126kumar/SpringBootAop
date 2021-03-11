package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MainException.class)
    public ResponseEntity<?> mainException(MainException exception) {
        Map response = new HashMap();
        response.put("data", null);
        response.put("error", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = DatabaseException.class)
    public ResponseEntity<?> handleDatabaseException(DatabaseException exception) {
        Map response = new HashMap();
        response.put("data", null);
        response.put("error", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MappingException.class)
    public ResponseEntity<?> handleMappingException(MappingException exception) {
        Map response = new HashMap();
        response.put("data", null);
        response.put("error", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }


}

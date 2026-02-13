package com.example.LoginSystem.exception;

import com.example.LoginSystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> userNotFound(UserNotFoundException unfe){
        ErrorDetails notFound = new ErrorDetails(unfe.getMessage(), 401, "Unauthorized");
        return new ResponseEntity<>(notFound,HttpStatus.UNAUTHORIZED);
    }
}

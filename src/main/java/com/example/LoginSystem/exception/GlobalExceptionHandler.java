package com.example.LoginSystem.exception;

import com.example.LoginSystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundExcpetion.class)
    public ResponseEntity<ErrorDetails> userNotFound(UserNotFoundExcpetion unfe){
        ErrorDetails notFound = new ErrorDetails(unfe.getMessage(), 404, "Not Found");
        return new ResponseEntity<>(notFound,HttpStatus.NOT_FOUND);
    }
}

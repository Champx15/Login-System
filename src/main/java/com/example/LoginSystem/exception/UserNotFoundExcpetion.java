package com.example.LoginSystem.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundExcpetion extends Exception{

    public UserNotFoundExcpetion(){
        super("User doesn't exist");
    }

}

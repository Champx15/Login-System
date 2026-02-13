package com.example.LoginSystem.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        super("Invalid credentials");
    }

}

package com.example.LoginSystem.controller;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private LoginService service;

//    @GetMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserRequestDto requestDto){
//        service.validateAccount(requestDto)
//    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto requestDto){
        UserResponseDto account = service.createAccount(requestDto);
        URI location = URI.create("/create/"+account.getId());
        return  ResponseEntity.created(location).body(account);
    }

}

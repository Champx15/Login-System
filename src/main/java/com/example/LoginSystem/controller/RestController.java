package com.example.LoginSystem.controller;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.exception.UserNotFoundException;
import com.example.LoginSystem.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDslKt.withRel;

@org.springframework.web.bind.annotation.RestController
@Tag(name="LoginSystemAPI",description = "There will be 2 apis one will accept email & password and will authenticate user, other one will create a new user based on email and password")
public class RestController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    @Operation(summary = "POST Operation",description = "This API will accept user email and password and validate it ")
    public ResponseEntity<?> login(@RequestBody UserRequestDto requestDto) throws UserNotFoundException {
        UserResponseDto userResponseDto = service.validateAccount(requestDto);
        return new ResponseEntity<>(userResponseDto,HttpStatus.ACCEPTED);


    }

    @PostMapping("/create")
    @Operation(summary = "POST Operation",description = "This API will accept email and password and create a new user ")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto requestDto) throws UserNotFoundException{
        UserResponseDto account = service.createAccount(requestDto);
        URI location = URI.create("/create/"+account.getId());
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RestController.class).login(requestDto)).withRel("login");
        account.add(link);
        return  ResponseEntity.created(location).body(account);
    }


}

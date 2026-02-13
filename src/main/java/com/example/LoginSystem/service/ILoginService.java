package com.example.LoginSystem.service;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.exception.UserNotFoundException;

public interface ILoginService {
    public UserResponseDto createAccount(UserRequestDto requestDto);
    public UserResponseDto validateAccount(UserRequestDto requestDto) throws UserNotFoundException;
}

package com.example.LoginSystem.service;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;

public interface ILoginService {
    public UserResponseDto createAccount(UserRequestDto requestDto);
    public UserResponseDto validateAccount(UserRequestDto requestDto);
}

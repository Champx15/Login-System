package com.example.LoginSystem.dto.mapper;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserResponseDto toDto(User user);
    User toUser(UserRequestDto requestDto);
}

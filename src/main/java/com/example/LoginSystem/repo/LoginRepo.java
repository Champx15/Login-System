package com.example.LoginSystem.repo;

import com.example.LoginSystem.dto.UserLoginDto;
import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<User,Long>{
    UserLoginDto findByEmail(String email);
}

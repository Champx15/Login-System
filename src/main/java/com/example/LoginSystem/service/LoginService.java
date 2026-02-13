package com.example.LoginSystem.service;

import com.example.LoginSystem.dto.UserRequestDto;
import com.example.LoginSystem.dto.UserResponseDto;
import com.example.LoginSystem.dto.mapper.UserDtoMapper;
import com.example.LoginSystem.exception.UserNotFoundException;
import com.example.LoginSystem.phashing.PWordHasher;
import com.example.LoginSystem.model.User;
import com.example.LoginSystem.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService{
    @Autowired
    private LoginRepo repo;

    @Autowired
    private UserDtoMapper mapper;

    @Override
    public UserResponseDto createAccount(UserRequestDto requestDto){
        User user = mapper.toUser(requestDto);
        user.setPassword(PWordHasher.encode(user.getPassword()));
        user = repo.save(user);
        return mapper.toDto(user);
    }

    @Override
    public UserResponseDto validateAccount(UserRequestDto requestDto) throws UserNotFoundException{
        User user = repo.findByEmail(requestDto.getEmail()).orElseThrow(UserNotFoundException::new);
        String unhashed = PWordHasher.decode(user.getPassword());
        boolean matching = unhashed.equals(requestDto.getPassword());
        if(!matching) throw new UserNotFoundException();
        return  mapper.toDto(user);
    }
}

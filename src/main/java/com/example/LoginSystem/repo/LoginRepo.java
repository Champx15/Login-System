package com.example.LoginSystem.repo;

import com.example.LoginSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}

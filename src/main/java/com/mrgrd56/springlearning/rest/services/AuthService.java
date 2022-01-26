package com.mrgrd56.springlearning.rest.services;

import com.mrgrd56.springlearning.rest.dto.LoginDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    public boolean validateCredentials(LoginDto loginDto) {
        return Objects.equals(loginDto.getLogin(), "admin") &&
               Objects.equals(loginDto.getPassword(), "admin");
    }
}

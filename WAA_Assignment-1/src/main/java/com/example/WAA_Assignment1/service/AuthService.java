package com.example.WAA_Assignment1.service;

import com.example.WAA_Assignment1.Dto.request.LoginRequest;
import com.example.WAA_Assignment1.Dto.response.LoginResponse;


public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}

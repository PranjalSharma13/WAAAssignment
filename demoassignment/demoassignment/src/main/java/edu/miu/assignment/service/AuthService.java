package edu.miu.assignment.service;



import edu.miu.assignment.entity.dto.request.LoginRequest;
import edu.miu.assignment.entity.dto.request.RefreshTokenRequest;
import edu.miu.assignment.entity.dto.response.LoginResponse;

import java.util.Collection;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

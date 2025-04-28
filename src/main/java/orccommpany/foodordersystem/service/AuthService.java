package orccommpany.foodordersystem.service;

import orccommpany.foodordersystem.dto.AuthRequest;
import orccommpany.foodordersystem.dto.AuthResponse;
import orccommpany.foodordersystem.dto.UserDto;

public interface AuthService {
    UserDto register(UserDto userDto, String password);
    AuthResponse login(AuthRequest request);
    
}

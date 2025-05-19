package orccommpany.foodordersystem.controller;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.AuthRequest;
import orccommpany.foodordersystem.dto.AuthResponse;
import orccommpany.foodordersystem.dto.UserDto;
import orccommpany.foodordersystem.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse authResponse = authService.login(request);
        return ResponseEntity.ok(authResponse);
    }


    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        return authService.register(userDto, userDto.getPassword());
    }
}


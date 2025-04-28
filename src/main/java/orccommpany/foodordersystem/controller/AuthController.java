
package orccommpany.foodordersystem.controller;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.AuthRequest;
import orccommpany.foodordersystem.dto.AuthResponse;
import orccommpany.foodordersystem.dto.UserDto;
import orccommpany.foodordersystem.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto, @RequestParam String password) {
        return authService.register(userDto, password);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}


package orccommpany.foodordersystem.controller;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.AuthRequest;
import orccommpany.foodordersystem.dto.UserDto;
import orccommpany.foodordersystem.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthPageController {

    private final AuthService authService;
    @GetMapping("/login")

    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute AuthRequest authRequest) {
        return "redirect:/menu.html";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute UserDto userDto) {
        authService.register(userDto, userDto.getPassword());
        return "redirect:/login";
    }

}

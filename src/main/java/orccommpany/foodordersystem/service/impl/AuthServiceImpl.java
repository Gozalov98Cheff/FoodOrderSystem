package orccommpany.foodordersystem.service.impl;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.config.JwtUtil;
import orccommpany.foodordersystem.dto.AuthRequest;
import orccommpany.foodordersystem.dto.AuthResponse;
import orccommpany.foodordersystem.dto.UserDto;
import orccommpany.foodordersystem.mapper.UserMapper;
import orccommpany.foodordersystem.model.Role;
import orccommpany.foodordersystem.model.User;
import orccommpany.foodordersystem.repository.RoleRepository;
import orccommpany.foodordersystem.repository.UserRepository;
import orccommpany.foodordersystem.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    @Override
    public UserDto register(UserDto userDto, String password) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(password));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setRoles(Collections.singleton(userRole));

        User saved = userRepository.save(user);

        UserDto dto = new UserDto();
        dto.setId(saved.getId());
        dto.setUsername(saved.getUsername());
        dto.setEmail(saved.getEmail());
        return dto;
    }


    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtil.generateToken(authentication);
        return new AuthResponse(token);
    }
}

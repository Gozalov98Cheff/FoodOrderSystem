package orccommpany.foodordersystem.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.model.Role;
import orccommpany.foodordersystem.model.User;
import orccommpany.foodordersystem.repository.RoleRepository;
import orccommpany.foodordersystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_ADMIN")));
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));


        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);
        }
    }
}

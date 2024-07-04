package com.example.permify.auth.api.repositories;

import org.springframework.stereotype.Repository;

import com.example.permify.auth.api.entities.Role;
import com.example.permify.auth.api.model.user.User;

@Repository
public class UserRepository {
    private final RoleRepository roleRepository;

    public UserRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // public User findUserByEmail(String email) {
    //     User user = new User(email, "123456");
    //     Role role;

    //     if (email.equals("admin@example.com")) {
    //         role = roleRepository.findByName("ADMIN").orElse(null);
    //     } else {
    //         role = roleRepository.findByName("USER").orElse(null);
    //     }

    //     user.setRole(role);
    //     return user;
    // }

    public User findUserByEmail(String email) {
        User user = new User(email, "123456");
        Role role;
    
        if (email.equals("admin@example.com")) {
            role = roleRepository.findByName("ADMIN").orElseThrow(() -> new RuntimeException("Admin role not found"));
        } else {
            role = roleRepository.findByName("USER").orElseGet(() -> new Role("USER"));
        }
    
        user.setRole(role);
        return user;
    }
}

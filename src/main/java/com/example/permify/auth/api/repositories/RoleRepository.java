package com.example.permify.auth.api.repositories;

import com.example.permify.auth.api.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class RoleRepository {

    private static final Map<String, Role> roles = new HashMap<>();

    static {
        Role userRole = new Role("USER");
        userRole.setId(1L);
        roles.put("USER", userRole);

        Role adminRole = new Role("ADMIN");
        adminRole.setId(2L);
        roles.put("ADMIN", adminRole);
    }

    public Optional<Role> findByName(String name) {
        return Optional.ofNullable(roles.get(name));
    }
}
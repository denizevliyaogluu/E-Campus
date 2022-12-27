package com.example.springsecurity.service;

import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void saveRole() {

        UserRole userRole = new UserRole(null,"ROLE_TEST");

        UserRole added_Role = userService.saveRole(userRole);
        assertNotNull(userRole.getId());
        assertEquals(userRole.getName(), added_Role.getName());
    }
}
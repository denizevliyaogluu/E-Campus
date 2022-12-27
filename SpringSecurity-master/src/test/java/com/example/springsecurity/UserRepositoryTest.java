package com.example.springsecurity.repos;

import com.example.springsecurity.models.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        User test_user = new User(null, "test user","username","123456",new ArrayList<>());
        userRepository.save(test_user);

        var result = userRepository.findByUsername("username");

        assertEquals(result.getUsername(), "username");

    }
}
package com.example.springsecurity.api;

import com.example.springsecurity.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class UserControllerTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    User test_user = new User(null, "test user","username","123456",new ArrayList<>());

    @Test
    void getUsers() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        mvc.perform(requestBuilder).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username="admin",roles={"ADMIN"})
    void saveUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content( objectMapper.writeValueAsString(test_user) )
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(status().isCreated());
    }

}
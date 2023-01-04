package com.example.springsecurity.service;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.services.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    void addDepartment() {

        Department dp = new Department();
        dp.setDepartmentName("Bilgisayar Mühendisliği");
        departmentService.addDepartment(dp);

    }
}

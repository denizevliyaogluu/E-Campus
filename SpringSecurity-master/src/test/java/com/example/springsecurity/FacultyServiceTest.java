package com.example.springsecurity.service;


import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FacultyServiceTest {
    @Autowired
    private FacultyService facultyService;

    @Test
    void addFaculty() {

        Faculty fc = new Faculty();
        fc.setFacultyName("Mühendislik ve Doğa Bilimleri Fakültesi");
        facultyService.addFaculty(fc);

    }
}

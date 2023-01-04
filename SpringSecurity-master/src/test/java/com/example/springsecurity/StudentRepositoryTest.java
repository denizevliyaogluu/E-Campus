package com.example.springsecurity.service;


import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.services.FacultyService;
import com.example.springsecurity.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentService studentService;

    @Test
    void addStudent() {

        Student st = new Student();
        st.setUsername("Deniz Evliyaoglu");

    }
}

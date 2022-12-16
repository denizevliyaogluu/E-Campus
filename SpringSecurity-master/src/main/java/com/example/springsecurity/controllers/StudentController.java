package com.example.springsecurity.controllers;


//ogrenci isleri: ogrenci kaydı, ogrenci bilgi goruntuleme

import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
import com.example.springsecurity.services.StudentService;
import com.example.springsecurity.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("students")

public class StudentController {

    public final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //ogrenci listesi
    @Secured("ROLE_OGRENCIISLERI")
    @GetMapping()
    public List<Student> GetStudents(){
        return studentService.getAll();
    }


}

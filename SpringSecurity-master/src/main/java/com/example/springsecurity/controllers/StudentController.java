package com.example.springsecurity.controllers;


//ogrenci isleri: ogrenci kaydı, ogrenci bilgi goruntuleme

import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
import com.example.springsecurity.services.StudentService;
import com.example.springsecurity.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
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
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id")Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @Secured("ROLE_OGRENCIISLERI")
    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok(student);
    }
    @Secured("ROLE_OGRENCIISLERI")
    @GetMapping("/{id}")
    public List<Student> getStudentByLessonId(@PathVariable Long id){
        return studentService.getStudentByLessonId(id);
    }
}

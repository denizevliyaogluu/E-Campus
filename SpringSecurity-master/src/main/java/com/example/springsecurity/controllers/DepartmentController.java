package com.example.springsecurity.controllers;


import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.LessonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
public class DepartmentController {
    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, LessonService lessonService){
        this.departmentService=departmentService;
    }
}

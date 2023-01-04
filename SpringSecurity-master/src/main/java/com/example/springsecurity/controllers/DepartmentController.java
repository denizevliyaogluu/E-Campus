package com.example.springsecurity.controllers;


import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import com.example.springsecurity.services.InstituteService;
import com.example.springsecurity.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
    public final DepartmentService departmentService;
    public final FacultyService facultyService;
    public final InstituteService instituteService;

    public DepartmentController(DepartmentService departmentService, LessonService lessonService, FacultyService facultyService, InstituteService instituteService){
        this.departmentService=departmentService;
        this.facultyService = facultyService;
        this.instituteService = instituteService;
    }
   // @Secured("ROLE_SISTEMYONETICISI")
    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departmentList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }
    //@Secured({"ROLE_SISTEMYONETICISI","ROLE_FAKULTEYONETIMI"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable(value = "id")Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
    //@Secured({"ROLE_SISTEMYONETICISI","ROLE_FAKULTEYONETIMI"})
    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return ResponseEntity.ok(department);
    }
    //@Secured("ROLE_SISTEMYONETICISI")
    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

   // @PostMapping("/faculty/{id}")
    @ResponseBody
    public ResponseEntity<Department> addDepartmentByFacultyId(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.addDepartmentByFacultyId(id,department),
                HttpStatus.CREATED);
    }

    //@PostMapping("/lesson/{id}")
    @ResponseBody
    public ResponseEntity<Department> addDepartmentByLessonId(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.addDepartmentByLessonId(id,department),
               HttpStatus.CREATED);
    }



}

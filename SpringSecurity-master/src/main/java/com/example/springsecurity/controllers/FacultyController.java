package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    public final FacultyService facultyService;
    public final DepartmentService departmentService;

    public FacultyController(FacultyService facultyService, DepartmentService departmentService){
        this.facultyService=facultyService;
        this.departmentService=departmentService;
    }
    
    @Secured("ROLE_SISTEMYONETICISI")
    @GetMapping()
    public ResponseEntity<?> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

   
   @Secured("ROLE_SISTEMYONETICISI")
   @PostMapping
   public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        facultyService.addFaculty(faculty);
        return ResponseEntity.ok(faculty);
   }
   @Secured("ROLE_SISTEMYONETICISI")
   @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentsByFacultyId(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getDepartmentsByFacultyId(id));
   }



}

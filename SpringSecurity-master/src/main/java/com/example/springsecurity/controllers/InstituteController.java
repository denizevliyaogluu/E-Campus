package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Institute;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.services.InstituteService;
import com.example.springsecurity.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("institute")
public class InstituteController {

    public final InstituteService instituteService;

    public InstituteController(InstituteService instituteService, UserService userService){

        this.instituteService = instituteService;
    }
    //@Secured("ROLE_SISTEMYONETICISI")
    @GetMapping()
    public ResponseEntity<?> getAllInstitutes(){
        return ResponseEntity.ok(instituteService.getAll());
    }

    //@Secured("ROLE_SISTEMYONETICISI")
    @PostMapping
    public ResponseEntity<Institute> addInstitutes(@RequestBody Institute institute){
        instituteService.addInstitute(institute);
        return ResponseEntity.ok(institute);
    }
    //@Secured("ROLE_SISTEMYONETICISI")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInstitute(@PathVariable(value = "id")Long id){
        instituteService.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }

    //@Secured("ROLE_SISTEMYONETICISI")
    @GetMapping("/{instituteId}")
    public Institute getInstituteById(@PathVariable Long instituteId){
        return instituteService.getInstituteById(instituteId);
    }

}

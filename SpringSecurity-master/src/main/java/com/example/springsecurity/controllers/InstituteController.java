package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Institute;
import com.example.springsecurity.services.InstituteService;
import com.example.springsecurity.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("institute")
public class InstituteController {

    public final InstituteService instituteService;

    public InstituteController(InstituteService instituteService, UserService userService){

        this.instituteService = instituteService;
    }
    
    @Secured("ROLE_SISTEMYONETICISI")
    @GetMapping()
    public ResponseEntity<?> getAllInstitutes(){
        return ResponseEntity.ok(instituteService.getAll());
    }
    
    @Secured("ROLE_SISTEMYONETICISI")
    @GetMapping("/{id}")
    public List<Institute> GetInstituteByUserID(@PathVariable Long id)
    {
        return instituteService.getInstituteByUserId(id);
    }
    @Secured("ROLE_SISTEMYONETICISI")
    @PostMapping
    public ResponseEntity<Institute> addInstitutes(@RequestBody Institute institute){
        instituteService.addInstitute(institute);
        return ResponseEntity.ok(institute);
    }



}

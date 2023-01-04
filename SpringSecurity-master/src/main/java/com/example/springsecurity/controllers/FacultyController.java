package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import com.example.springsecurity.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    public final FacultyService facultyService;
    public final DepartmentService departmentService;
    private final PersonnelService personnelService;

    public FacultyController(FacultyService facultyService, DepartmentService departmentService, PersonnelService personnelService){
        this.facultyService=facultyService;
        this.departmentService=departmentService;
        this.personnelService = personnelService;
    }


    //@Secured("ROLE_SISTEMYONETICISI")
    @GetMapping()
    public ResponseEntity<?> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

    //@Secured("ROLE_SISTEMYONETICISI")
    @PostMapping()
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        facultyService.addFaculty(faculty);
        return ResponseEntity.ok(faculty);
   }
    //@Secured("ROLE_SISTEMYONETICISI")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFaculty(@PathVariable(value = "id")Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
    //@Secured("ROLE_SISTEMYONETICISI")
    @GetMapping("/{facultyId}")
    public Faculty getFacultyById(@PathVariable Long facultyId){
        return facultyService.getFacultyById(facultyId);
    }

    //Secured("ROLE_SISTEMYONETICISI")
    @PostMapping("/institute/{id}")
    @ResponseBody
    public ResponseEntity<Faculty> addFacultyByInstituteId(@PathVariable Long id, @RequestBody Faculty faculty){
        return new ResponseEntity<>(facultyService.addFacultyByInstituteId(id,faculty),
                HttpStatus.CREATED);
    }



}

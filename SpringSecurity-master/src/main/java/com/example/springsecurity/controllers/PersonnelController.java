package com.example.springsecurity.controllers;


import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import com.example.springsecurity.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    public final PersonnelService personnelService;
    public final FacultyService facultyService;
    public final DepartmentService departmentService;

    public PersonnelController(PersonnelService personnelService, FacultyService facultyService, DepartmentService departmentService) {
        this.personnelService = personnelService;
        this.facultyService = facultyService;
        this.departmentService = departmentService;
    }
    //@Secured("ROLE_INSANKAYNAKLARI")
    @GetMapping()
    public List<Personnel> getAllPersonnel(){

        return personnelService.getAllPersonnel();
    }
    //@Secured("ROLE_INSANKAYNAKLARI")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonnel(@PathVariable(value = "id")Long id){
        personnelService.deletePersonnel(id);
        return ResponseEntity.noContent().build();
    }

    //@Secured("ROLE_INSANKAYNAKLARI")
    @PostMapping()
    public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel){
        personnelService.addPersonnel(personnel);
        return ResponseEntity.ok(personnel);
    }

    //@Secured("ROLE_INSANKAYNAKLARI")
    @GetMapping("/{personnelId}")
    public Personnel getPersonnelById(@PathVariable Long personnelId){
        return personnelService.getPersonnelById(personnelId);
    }

    //@Secured("ROLE_INSANKAYNAKLARI")
    @PostMapping("/contract/{id}")
    @ResponseBody
    public ResponseEntity<Personnel> addPersonnelByContractId(@PathVariable Long id, @RequestBody Personnel personnel){
        return new ResponseEntity<>(personnelService.addPersonnelByContractId(id,personnel),
                HttpStatus.CREATED);
    }
    @PostMapping("/faculty/{id}")
    @ResponseBody
    public ResponseEntity<Personnel> addPersonnelByFacultyId(@PathVariable Long id, @RequestBody Personnel personnel){
        return new ResponseEntity<>(facultyService.addPersonelByFacultyId(id,personnel),
                HttpStatus.CREATED);
    }
    @PostMapping("/department/{id}")
    @ResponseBody
    public ResponseEntity<Personnel> addPersonnelByDepartmentId(@PathVariable Long id, @RequestBody Personnel personnel){
        return new ResponseEntity<>(departmentService.addPersonelByDepartmentId(id,personnel),
                HttpStatus.CREATED);
    }

}

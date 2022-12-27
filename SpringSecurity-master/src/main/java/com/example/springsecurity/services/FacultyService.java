package com.example.springsecurity.services;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@Slf4j

public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final DepartmentRepository departmentRepository;

    public FacultyService(FacultyRepository facultyRepository, DepartmentRepository departmentRepository){
        this.facultyRepository=facultyRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Faculty> getAllFaculty(){
        log.info("Get all faculties..");
        return facultyRepository.findAll();
    }
    public void addFaculty(Faculty faculty){
        facultyRepository.save(faculty);
    }
    public List<Faculty> getFacultyByInstituteId(Long instituteId){
        return facultyRepository.findAllByInstituteId(instituteId);
    }
    public void addDepartmentByFacultyId(Department department, Long facultyId){
        department.setFaculty(facultyRepository.findById(facultyId).get());
        departmentRepository.save(department);
    }
    public Collection<Department> getDepartmentsByFacultyId(Long facultyId){
        return facultyRepository.findById(facultyId).get().getDepartments();
    }
    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }
}


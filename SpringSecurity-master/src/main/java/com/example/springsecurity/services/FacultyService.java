package com.example.springsecurity.services;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.repos.InstituteRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j

public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final DepartmentRepository departmentRepository;
    private final InstituteRepository instituteRepository;
    private final PersonnelRepository personnelRepository;

    public FacultyService(FacultyRepository facultyRepository, DepartmentRepository departmentRepository, InstituteRepository instituteRepository, PersonnelRepository personnelRepository){
        this.facultyRepository=facultyRepository;
        this.departmentRepository = departmentRepository;
        this.instituteRepository = instituteRepository;
        this.personnelRepository = personnelRepository;
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

    @Secured("ROLE_SISTEMYONETICISI")
    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public Faculty getFacultyById(Long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty addFacultyByInstituteId(Long id, Faculty faculty){
        faculty.setInstitute(instituteRepository.findById(id).orElse(null));
        return facultyRepository.save(faculty);
    }
    public Personnel addPersonelByFacultyId(Long id,Personnel personnel){
        personnel.setFaculty(facultyRepository.findById(id).orElse(null));
        return personnelRepository.save(personnel);
    }

}

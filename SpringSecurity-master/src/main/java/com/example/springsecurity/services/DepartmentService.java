package com.example.springsecurity.services;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.repos.LessonRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LessonRepository lessonRepository;
    private final FacultyRepository facultyRepository;
    private final PersonnelRepository personnelRepository;

    public DepartmentService(DepartmentRepository departmentRepository, LessonRepository lessonRepository, FacultyRepository facultyRepository, PersonnelRepository personnelRepository) {
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
        this.facultyRepository = facultyRepository;

        this.personnelRepository = personnelRepository;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }
    public void addLessonByDepartmentId(Lesson lesson, Long departmentId){
        lesson.setDepartment(departmentRepository.findById(departmentId).get());
        lessonRepository.save(lesson);
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    public Department addDepartmentByFacultyId(Long id, Department department){
        department.setFaculty(facultyRepository.findById(id).orElse(null));
        return departmentRepository.save(department);
    }
    public Department addDepartmentByLessonId(Long id, Department department){
        department.setLesson(lessonRepository.findById(id).orElse(null));
        return departmentRepository.save(department);
    }

    public Personnel addPersonelByDepartmentId(Long id, Personnel personnel){
        personnel.setDepartment(departmentRepository.findById(id).orElse(null));
        return personnelRepository.save(personnel);
    }
}

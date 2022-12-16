package com.example.springsecurity.services;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LessonRepository lessonRepository;

    public DepartmentService(DepartmentRepository departmentRepository, LessonRepository lessonRepository) {
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
    }
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }
    public List<Department> getDepartmentByFaculty(Long facultyId ){
        return departmentRepository.findAllByFacultyId(facultyId);
    }
    public void addLesson(Lesson lesson, Long departmentId){
        lesson.setDepartment(departmentRepository.findById(departmentId).get());
        lessonRepository.save(lesson);
    }
    public Collection<Lesson> getLessonByDepartmentId(Long departmentId){
        return departmentRepository.findById(departmentId).get().getLessons();
    }

}

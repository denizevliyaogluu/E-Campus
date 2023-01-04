package com.example.springsecurity.services;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.LessonRepository;
import com.example.springsecurity.repos.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional

public class LessonService {
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;


    public LessonService(LessonRepository lessonRepository, StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Lesson> getAllLessons() {
        log.info("Get all lessonss..");
        return lessonRepository.findAll();
    }

    public Lesson saveLesson(Lesson lesson) {
        log.info("Saving lesson..");
        lessonRepository.save(lesson);
        return lesson;
    }

    public Lesson addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
        return lesson;
    }

    public List<Lesson> getLessonByDepartmentId(Long departmentId) {
        return lessonRepository.findAllByDepartmentId(departmentId);

    }
    public void addStudentByLessonId(Student student, Long lessonId) {
        student.setLesson(lessonRepository.findById(lessonId).get());
        studentRepository.save(student);
    }
    public Lesson getLessonById(Long id){
        return lessonRepository.findById(id).get();
    }
    public Lesson addLessonByDepartmentId(Long id, Lesson lesson){
        lesson.setDepartment(departmentRepository.findById(id).orElse(null));
        return lessonRepository.save(lesson);
    }
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public void updateLesson(Lesson lesson, Long id){
        lessonRepository.save(lesson);
    }
    public void saveOrUpdate(Lesson lesson){
        lessonRepository.save(lesson);
    }
}

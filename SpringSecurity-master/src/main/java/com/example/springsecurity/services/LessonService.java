package com.example.springsecurity.services;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.LessonRepository;
import com.example.springsecurity.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@Transactional

public class LessonService {
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;


    public LessonService(LessonRepository lessonRepository, StudentRepository studentRepository) {
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
    }

    public List<Lesson> getAllLessons(){
        log.info("Get all lessonss..");
        return lessonRepository.findAll();
    }
    public Lesson saveLesson(Lesson lesson){
        log.info("Saving lesson..");
        lessonRepository.save(lesson);
        return lesson;
    }
    public void addLesson(Lesson lesson){
        lessonRepository.save(lesson);
    }
    public List<Lesson> getLessonByDepartment(Long departmentId){
        return lessonRepository.findAllByDepartmentId(departmentId);
    }
    public void addStudent(Student student, Long lessonId){
        student.setLesson(lessonRepository.findById(lessonId).get());
        //lessonRepository.save(student);
    }
    public Collection<Student> getStudentsByLessonId(Long lessonId){
        return lessonRepository.findById(lessonId).get().getStudents();
    }

}

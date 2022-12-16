package com.example.springsecurity.services;


import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.StudentRepository;
import com.example.springsecurity.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public StudentService(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> getStudentByLesson(Long lessonId){
        return studentRepository.findAllByLessonId(lessonId);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

}

package com.example.springsecurity.services;


import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.LessonRepository;
import com.example.springsecurity.repos.StudentRepository;
import com.example.springsecurity.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public StudentService(UserRepository userRepository, StudentRepository studentRepository, LessonRepository lessonRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;

        this.lessonRepository = lessonRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> getStudentByLessonId(Long lessonId){
        return studentRepository.findAllByLessonId(lessonId);
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public Student addStudentByLessonId(Long id, Student student){
        student.setLesson(lessonRepository.findById(id).orElse(null));
        return studentRepository.save(student);
    }

}

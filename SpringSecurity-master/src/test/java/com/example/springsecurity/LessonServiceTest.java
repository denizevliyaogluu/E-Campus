package com.example.springsecurity.service;


import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LessonServiceTest {
    @Autowired
    private LessonService lessonService;

    @Test
    void addLesson() {
        Lesson ls = new Lesson();
        ls.setLessonName("Sunucu Taraflı Programlama");
        lessonService.addLesson(ls);
    }
}

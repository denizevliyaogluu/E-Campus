package com.example.springsecurity.service;

import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.services.LessonService;
import com.example.springsecurity.services.PersonnelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonnelServiceTest {
    @Autowired
    private PersonnelService personnelService;

    @Test
    void addPersonnel() {

        Personnel pr = new Personnel();
        pr.setPersonnelType("Öğretmen");
        personnelService.addPersonnel(pr);
    }
}

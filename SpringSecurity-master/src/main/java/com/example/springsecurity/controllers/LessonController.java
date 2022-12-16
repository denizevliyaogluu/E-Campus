package com.example.springsecurity.controllers;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//ogrenci: ders listesi görüntüleme
//ogrenci isleri: ders ekleme, ders cikarma, ders kaydı olusturma
//fakulte yoneticisi: ders ekleme, ders cıkarma, ders kaydı onaylama


@RestController
@RequestMapping("lesson")
public class LessonController {
    public final LessonService lessonService;

    public LessonController(LessonService lessonService){
        this.lessonService=lessonService;
    }


    @Secured("ROLE_OGRENCIISLERI")
    @GetMapping()
    public ResponseEntity<?> getAllLessons(){
        return ResponseEntity.ok(lessonService.getAllLessons());
    }




}

package com.example.springsecurity.controllers;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

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



    @GetMapping()
    public ResponseEntity<?> getAllLessons(){
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @Secured("ROLE_OGRENCIISLERI")
    @PostMapping()
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson){
        lessonService.addLesson(lesson);
        return ResponseEntity.ok(lesson);
    }
    @Secured("ROLE_OGRENCIISLERI")
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteLesson(@PathVariable(value = "id")Long id){
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

   /* @GetMapping("{id}")
    public List<Lesson> getLessonByDepartmentId(@PathVariable Long id){
        return lessonService.getLessonByDepartmentId(id);
    }*/
   /* @Secured("ROLE_OGRENCIISLERI")
    @GetMapping("{id}")
    public List<Lesson> getLessonByStudentId(@PathVariable Long id){
        return lessonService.getLessonByStudentId(id);
    }*/


}


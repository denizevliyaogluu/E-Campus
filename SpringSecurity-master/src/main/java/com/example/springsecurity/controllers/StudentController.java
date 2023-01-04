package com.example.springsecurity.controllers;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("lesson")
public class LessonController {
    public final LessonService lessonService;
    public LessonController(LessonService lessonService){
        this.lessonService=lessonService;
    }

    //@Secured({"ROLE_OGRENCIISLERI","ROLE_OGRENCI"})
    @GetMapping()
    public ResponseEntity<?> getAllLessons(){
        return ResponseEntity.ok(lessonService.getAllLessons());
    }
    //@Secured({"ROLE_OGRENCIISLERI","ROLE_FAKULTEYONETIMI","ROLE_ENSTITUYONETIMI"})
    @PostMapping()
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonService.addLesson(lesson);
    }
    //@Secured({"ROLE_OGRENCIISLERI","ROLE_OGRENCI"})
    @GetMapping("/{lessonId}")
    public Lesson getLessonById(@PathVariable Long lessonId){
        return lessonService.getLessonById(lessonId);
    }
    //@Secured("ROLE_OGRENCIISLERI")
    @PostMapping("/department/{id}")
    @ResponseBody
    public ResponseEntity<Lesson> addLessonByDepartmentId(@PathVariable Long id, @RequestBody Lesson lesson){
        return new ResponseEntity<>(lessonService.addLessonByDepartmentId(id,lesson),
                HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLesson(@PathVariable(value = "id")Long id){
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
    //@Secured("ROLE_OGRENCI")
    @PutMapping()
    public Lesson updateLesson(@RequestBody Lesson lesson){
        lessonService.saveOrUpdate(lesson);
        return lesson;
    }
}

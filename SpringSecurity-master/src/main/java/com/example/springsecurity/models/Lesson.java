package com.example.springsecurity.models;
import com.example.springsecurity.services.LessonService;
import com.example.springsecurity.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @JsonIgnore
    private String lessonName;

    @JsonIgnore
    // @ManyToOne
    @OneToMany(mappedBy="lesson")
    private List<User> user=new ArrayList<>() ;

    private LessonStatus status;


    @JsonIgnore
    @ManyToOne
    private Department department;

    @JsonIgnore
    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public Lesson(String lessonName, LessonStatus status) {
        this.lessonName = lessonName;
        if (status==null)
            status = LessonStatus.APPROVED;
        this.status = status;
    }
}

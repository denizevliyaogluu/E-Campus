package com.example.springsecurity.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;


@Entity
@Data
public class Student extends User{
    public String studentNumber;
    private StudentStatus status;

    @JsonIgnore
    @ManyToOne
    private Lesson lesson;

}

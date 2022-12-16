package com.example.springsecurity.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
public class Student extends User{
    public String studentNumber;

    @JsonIgnore
    @ManyToOne
    private Lesson lesson;



}

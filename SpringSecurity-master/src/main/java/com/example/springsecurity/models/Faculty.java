package com.example.springsecurity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id",nullable = false)
    private Long id;

    private String facultyName;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany
    private List<Personnel> personnels = new ArrayList<>();

    /*@OneToMany(mappedBy = "faculty")
    private List<Department> departmentList=new ArrayList<>();
   /* @JsonIgnore
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments = new ArrayList<>();*/

    @JsonIgnore
    @ManyToOne
    private Institute institute;

}

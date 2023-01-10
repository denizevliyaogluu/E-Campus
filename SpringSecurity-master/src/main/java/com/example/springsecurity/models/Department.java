package com.example.springsecurity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    private String departmentName;

    @JsonIgnore
    //@ManyToOne
      @OneToMany(mappedBy="department")
    private List<User> user=new ArrayList<>() ;

    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @OneToMany(mappedBy="department")
    private List<Lesson> lesson=new ArrayList<>() ;

}

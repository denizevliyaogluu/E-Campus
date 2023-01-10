package com.example.springsecurity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    private String instituteName;

    @JsonIgnore
    //@ManyToOne
    //private User user;
    @OneToMany(mappedBy="institute")
    private List<User> user=new ArrayList<>() ;

   /* @JsonIgnore
    @OneToMany(mappedBy = "institute")
    private List<Faculty> facultyList = new ArrayList<>();*/

    @JsonIgnore
    //@ManyToOne
    @OneToMany(mappedBy="institute")
    private List<Faculty> faculty=new ArrayList<>() ;

    @JsonIgnore
    @OneToMany(mappedBy="institute")
    private List<Student> student=new ArrayList<>() ;


}

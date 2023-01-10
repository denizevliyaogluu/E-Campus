package com.example.springsecurity.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;


@Entity
@Data
public class Personnel extends User{
    public String personnelType;

    @JsonIgnore
    @ManyToOne
    private Contract contract;

    @JsonIgnore
   // @ManyToMany
   // private Faculty faculty;
   @OneToMany(mappedBy="personnel")
    private List<Faculty> faculty=new ArrayList<>() ;

    @JsonIgnore
    //@ManyToMany
    //private Department department;
    @OneToMany(mappedBy="personnel")
    private List<Department> department=new ArrayList<>() ;

}

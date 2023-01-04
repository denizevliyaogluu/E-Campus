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
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @ManyToOne
    private Department department;

}

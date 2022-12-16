package com.example.springsecurity.repos;

import com.example.springsecurity.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByInstituteId(Long instituteId);
}
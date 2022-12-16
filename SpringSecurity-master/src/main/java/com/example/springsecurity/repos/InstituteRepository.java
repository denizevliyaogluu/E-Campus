package com.example.springsecurity.repos;

import com.example.springsecurity.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
    List<Institute> findAllByUserId(Long userId);
}
package com.example.springsecurity.repos;

import com.example.springsecurity.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long>
{
   List<Lesson> findAllByDepartmentId(Long departmentId);
}

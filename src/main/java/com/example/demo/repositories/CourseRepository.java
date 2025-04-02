package com.example.demo.repositories;

import com.example.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findByCourseName(String courseName);

    boolean existsByCourseName(String courseName);
}
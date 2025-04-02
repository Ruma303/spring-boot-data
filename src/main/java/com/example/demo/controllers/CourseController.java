package com.example.demo.controllers;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> findById(@PathVariable Integer id) {
        return courseRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Course> findByCourseName(@PathVariable String name) {
        return courseRepository.findByCourseName(name);
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        courseRepository.deleteById(id);
    }
}
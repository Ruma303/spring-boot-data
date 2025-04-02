package com.example.demo.controllers;

import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> findById(@PathVariable Integer id) {
        return teacherRepository.findById(id);
    }

    @GetMapping("/lastname/{lastName}")
    public List<Teacher> findByLastName(@PathVariable String lastName) {
        return teacherRepository.findByLastName(lastName);
    }

    @GetMapping("/fullname")
    public List<Teacher> findByFullName(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return teacherRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        teacherRepository.deleteById(id);
    }
}
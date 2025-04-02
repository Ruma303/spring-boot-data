package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Integer id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/lastname/{lastName}")
    public List<Student> findByLastName(@PathVariable String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public Optional<Student> findByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }
}
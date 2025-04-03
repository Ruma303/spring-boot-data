package com.example.demo.controllers;

import com.example.demo.dtos.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
            .map(StudentDTO::fromEntity)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) {
        return studentRepository.findById(id)
            .map(StudentDTO::fromEntity)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lastname/{lastName}")
    public List<StudentDTO> findByLastName(@PathVariable String lastName) {
        return studentRepository.findByLastName(lastName).stream()
            .map(StudentDTO::fromEntity)
            .collect(Collectors.toList());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> findByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email)
            .map(StudentDTO::fromEntity)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
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
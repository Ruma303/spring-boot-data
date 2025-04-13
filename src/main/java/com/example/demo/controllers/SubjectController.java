package com.example.demo.controllers;

import com.example.demo.entities.Subject;
import com.example.demo.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Subject> findById(@PathVariable Integer id) {
        return subjectRepository.findById(id);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Subject> findByTeacherId(@PathVariable Integer teacherId) {
        return subjectRepository.findByTeacherId(teacherId);
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        subjectRepository.deleteById(id);
    }
}
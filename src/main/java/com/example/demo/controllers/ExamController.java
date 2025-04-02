package com.example.demo.controllers;

import com.example.demo.entities.Exam;
import com.example.demo.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exam> findById(@PathVariable Integer id) {
        return examRepository.findById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> findByStudent(@PathVariable Integer studentId) {
        return examRepository.findByIdStudent(studentId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<Exam> findBySubject(@PathVariable Integer subjectId) {
        return examRepository.findByIdSubject(subjectId);
    }

    @GetMapping("/grade/{minGrade}")
    public List<Exam> findWithMinGrade(@PathVariable BigDecimal minGrade) {
        return examRepository.findExamsWithMinGrade(minGrade);
    }

    @PostMapping
    public Exam save(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        examRepository.deleteById(id);
    }
}
package com.example.demo.controllers;

import com.example.demo.entities.Exam;
import com.example.demo.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<Page<Exam>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "examDate,desc") String[] sort
    ) {
        Sort sortOrder = Sort.by(Sort.Direction.fromString(sort[1]), sort[0]);
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        Page<Exam> result = examService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> findById(@PathVariable Integer id) {
        return examService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> findByStudent(@PathVariable Integer studentId) {
        return examService.findByStudent(studentId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<Exam> findBySubject(@PathVariable Integer subjectId) {
        return examService.findBySubject(subjectId);
    }

    @GetMapping("/grade/{minGrade}")
    public List<Exam> findWithMinGrade(@PathVariable BigDecimal minGrade) {
        return examService.findWithMinGrade(minGrade);
    }

    @PostMapping
    public ResponseEntity<Exam> save(@RequestBody Exam exam) {
        Exam saved = examService.save(exam);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        examService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
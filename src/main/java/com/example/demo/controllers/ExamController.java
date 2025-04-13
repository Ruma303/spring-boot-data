package com.example.demo.controllers;

import com.example.demo.dtos.ExamResponseDTO;
import com.example.demo.wrappers.PageWrapper;
import com.example.demo.entities.Exam;
import com.example.demo.mappers.ExamMapper;
import com.example.demo.services.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;
    private final ExamMapper examMapper;

    @GetMapping
    public ResponseEntity<PageWrapper<ExamResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "examDate,desc") String[] sort
    ) {
        Sort sortOrder = Sort.by(Sort.Direction.fromString(sort[1]), sort[0]);
        Pageable pageable = PageRequest.of(page, size, sortOrder);

        Page<Exam> result = examService.findAll(pageable);
        Page<ExamResponseDTO> mapped = result.map(examMapper::toDTO);

        return ResponseEntity.ok(new PageWrapper<>(mapped));
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
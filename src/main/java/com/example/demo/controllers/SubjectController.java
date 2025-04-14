package com.example.demo.controllers;

import com.example.demo.dtos.SubjectRequestDTO;
import com.example.demo.entities.Subject;
import com.example.demo.repositories.SubjectRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Subject> findById(@PathVariable Integer id) {
        return subjectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Subject> findByTeacherId(@PathVariable Integer teacherId) {
        return subjectRepository.findByTeacherId(teacherId);
    }

    @PostMapping
    public ResponseEntity<Subject> save(@Valid @RequestBody SubjectRequestDTO dto) {
        Subject subject = new Subject();
        subject.setSubjectName(dto.getSubjectName());
        subject.setIdTeacher(dto.getIdTeacher());

        Subject saved = subjectRepository.save(subject);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (!subjectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        subjectRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
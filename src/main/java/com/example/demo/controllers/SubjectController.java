package com.example.demo.controllers;

import com.example.demo.dtos.SubjectRequestDTO;
import com.example.demo.dtos.SubjectResponseDTO;
import com.example.demo.services.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectResponseDTO> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> findById(@PathVariable Integer id) {
        return subjectService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/teacher/{teacherId}")
    public List<SubjectResponseDTO> findByTeacherId(@PathVariable Integer teacherId) {
        return subjectService.findByTeacherId(teacherId);
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> save(@Valid @RequestBody SubjectRequestDTO dto) {
        SubjectResponseDTO saved = subjectService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        subjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
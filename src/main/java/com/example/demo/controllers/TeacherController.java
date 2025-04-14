package com.example.demo.controllers;

import com.example.demo.dtos.TeacherRequestDTO;
import com.example.demo.dtos.TeacherResponseDTO;
import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<TeacherResponseDTO> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> findById(@PathVariable Integer id) {
        return teacherRepository.findById(id)
                .map(teacher -> modelMapper.map(teacher, TeacherResponseDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lastname/{lastName}")
    public List<TeacherResponseDTO> findByLastName(@PathVariable String lastName) {
        return teacherRepository.findByLastName(lastName).stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/fullname")
    public List<TeacherResponseDTO> findByFullName(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return teacherRepository.findByFirstNameAndLastName(firstName, lastName).stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponseDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> save(@Valid @RequestBody TeacherRequestDTO dto) {
        Teacher teacher = modelMapper.map(dto, Teacher.class);
        Teacher saved = teacherRepository.save(teacher);
        TeacherResponseDTO response = modelMapper.map(saved, TeacherResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody TeacherRequestDTO dto
    ) {
        Optional<Teacher> existingOpt = teacherRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Teacher existing = existingOpt.get();
        modelMapper.map(dto, existing);
        Teacher updated = teacherRepository.save(existing);
        TeacherResponseDTO response = modelMapper.map(updated, TeacherResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
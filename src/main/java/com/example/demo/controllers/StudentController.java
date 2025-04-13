package com.example.demo.controllers;

import com.example.demo.dtos.StudentRequestDTO;
import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Integer id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lastname/{lastName}")
    public List<StudentResponseDTO> findByLastName(@PathVariable String lastName) {
        return studentRepository.findByLastName(lastName).stream()
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentResponseDTO> findByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> save(@RequestBody StudentRequestDTO dto) {
        Optional<Course> courseOpt = courseRepository.findById(dto.getCourseId());
        if (courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());
        student.setAge(dto.getAge());
        student.setBirthdate(dto.getBirthdate());
        student.setCourse(courseOpt.get());

        Student saved = studentRepository.save(student);
        return ResponseEntity.ok(modelMapper.map(saved, StudentResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Integer id, @RequestBody StudentRequestDTO dto) {
        Optional<Course> courseOpt = courseRepository.findById(dto.getCourseId());
        if (courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return studentRepository.findById(id)
                .map(existing -> {
                    existing.setFirstName(dto.getFirstName());
                    existing.setLastName(dto.getLastName());
                    existing.setEmail(dto.getEmail());
                    existing.setPassword(dto.getPassword());
                    existing.setAge(dto.getAge());
                    existing.setBirthdate(dto.getBirthdate());
                    existing.setCourse(courseOpt.get());
                    Student updated = studentRepository.save(existing);
                    return ResponseEntity.ok(modelMapper.map(updated, StudentResponseDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }
}
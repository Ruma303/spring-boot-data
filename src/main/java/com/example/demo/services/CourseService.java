package com.example.demo.services;

import com.example.demo.dtos.CourseRequestDTO;
import com.example.demo.dtos.CourseResponseDTO;
import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public List<CourseResponseDTO> findAll() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<CourseResponseDTO> findById(Integer id) {
        return courseRepository.findById(id)
                .map(course -> modelMapper.map(course, CourseResponseDTO.class));
    }

    public Optional<CourseResponseDTO> findByCourseName(String name) {
        return courseRepository.findByCourseName(name)
                .map(course -> modelMapper.map(course, CourseResponseDTO.class));
    }

    @Transactional
    public CourseResponseDTO save(CourseRequestDTO dto) {
        // Puoi controllare duplicati se necessario
        if (courseRepository.existsByCourseName(dto.getCourseName())) {
            throw new IllegalArgumentException("Nome del corso già esistente");
        }

        Course course = modelMapper.map(dto, Course.class);
        Course saved = courseRepository.save(course);
        return modelMapper.map(saved, CourseResponseDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Corso con ID " + id + " non trovato");
        }
        courseRepository.deleteById(id);
    }
}
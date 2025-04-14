package com.example.demo.mappers;

import com.example.demo.dtos.CourseRequestDTO;
import com.example.demo.dtos.CourseResponseDTO;
import com.example.demo.entities.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CourseMapping {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void configure() {

        // Mapping: Course → CourseResponseDTO
        modelMapper.createTypeMap(Course.class, CourseResponseDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Course::getId, CourseResponseDTO::setId);
                    mapper.map(Course::getCourseName, CourseResponseDTO::setCourseName);
                });

        // Mapping: CourseRequestDTO → Course
        modelMapper.createTypeMap(CourseRequestDTO.class, Course.class)
                .addMappings(mapper -> {
                    mapper.map(CourseRequestDTO::getCourseName, Course::setCourseName);
                });
    }
}
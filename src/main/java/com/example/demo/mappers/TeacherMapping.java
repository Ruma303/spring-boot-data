package com.example.demo.mappers;

import com.example.demo.dtos.TeacherRequestDTO;
import com.example.demo.dtos.TeacherResponseDTO;
import com.example.demo.entities.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TeacherMapping {

    private final ModelMapper modelMapper;

    public TeacherMapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void configure() {
        // Teacher → TeacherResponseDTO
        modelMapper.createTypeMap(Teacher.class, TeacherResponseDTO.class);

        // TeacherRequestDTO → Teacher
        modelMapper.createTypeMap(TeacherRequestDTO.class, Teacher.class);
    }
}
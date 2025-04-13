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

        // Mapping: Teacher → TeacherResponseDTO (output)
        modelMapper.createTypeMap(Teacher.class, TeacherResponseDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Teacher::getId, TeacherResponseDTO::setId);
                    mapper.map(Teacher::getFirstName, TeacherResponseDTO::setFirstName);
                    mapper.map(Teacher::getLastName, TeacherResponseDTO::setLastName);
                    mapper.map(Teacher::getEmail, TeacherResponseDTO::setEmail);
                });

        // Mapping: TeacherRequestDTO → Teacher (input)
        modelMapper.createTypeMap(TeacherRequestDTO.class, Teacher.class)
                .addMappings(mapper -> {
                    mapper.map(TeacherRequestDTO::getFirstName, Teacher::setFirstName);
                    mapper.map(TeacherRequestDTO::getLastName, Teacher::setLastName);
                    mapper.map(TeacherRequestDTO::getEmail, Teacher::setEmail);
                    mapper.map(TeacherRequestDTO::getPassword, Teacher::setPassword);
                });
    }
}
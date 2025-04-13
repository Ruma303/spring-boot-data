package com.example.demo.mappers;

import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entities.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class StudentMapping {

    private final ModelMapper modelMapper;

    public StudentMapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void configure() {
        TypeMap<Student, StudentResponseDTO> typeMap = modelMapper.createTypeMap(Student.class, StudentResponseDTO.class);

        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getCourse().getCourseName(), StudentResponseDTO::setCourseName);
        });
    }
}
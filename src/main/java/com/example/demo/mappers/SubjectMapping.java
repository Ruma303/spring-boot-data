package com.example.demo.mappers;

import com.example.demo.dtos.SubjectRequestDTO;
import com.example.demo.dtos.SubjectResponseDTO;
import com.example.demo.entities.Subject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class SubjectMapping {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void configure() {

        // Mapping: Subject → SubjectResponseDTO
        modelMapper.createTypeMap(Subject.class, SubjectResponseDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Subject::getId, SubjectResponseDTO::setId);
                    mapper.map(Subject::getSubjectName, SubjectResponseDTO::setSubjectName);
                });

        // Mapping: SubjectRequestDTO → Subject
        modelMapper.createTypeMap(SubjectRequestDTO.class, Subject.class)
                .addMappings(mapper -> {
                    mapper.map(SubjectRequestDTO::getSubjectName, Subject::setSubjectName);
                    mapper.map(SubjectRequestDTO::getIdTeacher, Subject::setIdTeacher);
                });
    }
}
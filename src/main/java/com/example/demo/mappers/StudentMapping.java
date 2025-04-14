package com.example.demo.mappers;

import com.example.demo.dtos.StudentDetailRequestDTO;
import com.example.demo.dtos.StudentDetailResponseDTO;
import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entities.Student;
import com.example.demo.converters.DateConverter;
import com.example.demo.converters.EnumConverter;
import com.example.demo.entities.StudentDetail;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentMapping {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void configure() {

        modelMapper.createTypeMap(Student.class, StudentResponseDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getCourse().getCourseName(), StudentResponseDTO::setCourseName);
                });

        PropertyMap<Student, StudentResponseDTO> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(DateConverter.localDateToString)
                        .map(source.getBirthdate(), destination.getBirthdateFormatted());

                using(EnumConverter.enumToString)
                        .map(source.getStatus(), destination.getStatusLabel());

                map(source.getFirstName(), destination.getFirstName());
                map(source.getLastName(), destination.getLastName());
                map(source.getEmail(), destination.getEmail());
            }
        };

        modelMapper.addMappings(propertyMap);

        // Mapping per StudentDetail
        modelMapper.createTypeMap(StudentDetailRequestDTO.class, StudentDetail.class);
        modelMapper.createTypeMap(StudentDetail.class, StudentDetailResponseDTO.class);
    }
}
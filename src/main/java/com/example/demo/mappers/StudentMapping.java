package com.example.demo.mappers;

import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entities.Student;
import com.example.demo.converters.DateConverter;
import com.example.demo.converters.EnumConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.PropertyMap;
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

        // TypeMap: mappatura personalizzata per Course.courseName → courseName
        TypeMap<Student, StudentResponseDTO> typeMap = modelMapper.createTypeMap(Student.class, StudentResponseDTO.class);
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getCourse().getCourseName(), StudentResponseDTO::setCourseName);
        });

        // PropertyMap: dichiarata con generics espliciti
        PropertyMap<Student, StudentResponseDTO> propertyMap = new PropertyMap<Student, StudentResponseDTO>() {
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
    }
}
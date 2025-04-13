package com.example.demo.services;

import com.example.demo.dtos.StudentRequestDTO;
import com.example.demo.dtos.StudentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentResponseDTO> findAll();

    Optional<StudentResponseDTO> findById(Integer id);

    List<StudentResponseDTO> findByLastName(String lastName);

    Optional<StudentResponseDTO> findByEmail(String email);

    Optional<StudentResponseDTO> save(StudentRequestDTO dto);

    Optional<StudentResponseDTO> update(Integer id, StudentRequestDTO dto);

    boolean deleteById(Integer id);
}

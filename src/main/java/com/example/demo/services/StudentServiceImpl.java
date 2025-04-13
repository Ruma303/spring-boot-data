package com.example.demo.services;

import com.example.demo.dtos.StudentRequestDTO;
import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentResponseDTO> findById(Integer id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public List<StudentResponseDTO> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName).stream()
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentResponseDTO> findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public Optional<StudentResponseDTO> save(StudentRequestDTO dto) {
        Optional<Course> courseOpt = courseRepository.findById(dto.getCourseId());
        if (courseOpt.isEmpty()) {
            return Optional.empty();
        }

        Student student = modelMapper.map(dto, Student.class);
        student.setCourse(courseOpt.get());

        Student saved = studentRepository.save(student);
        return Optional.of(modelMapper.map(saved, StudentResponseDTO.class));
    }

    @Override
    public Optional<StudentResponseDTO> update(Integer id, StudentRequestDTO dto) {
        Optional<Student> existingOpt = studentRepository.findById(id);
        Optional<Course> courseOpt = courseRepository.findById(dto.getCourseId());

        if (existingOpt.isEmpty() || courseOpt.isEmpty()) {
            return Optional.empty();
        }

        Student existing = existingOpt.get();
        modelMapper.map(dto, existing);
        existing.setCourse(courseOpt.get());

        Student updated = studentRepository.save(existing);
        return Optional.of(modelMapper.map(updated, StudentResponseDTO.class));
    }

    @Override
    public boolean deleteById(Integer id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
package com.example.demo.services;

import com.example.demo.dtos.TeacherRequestDTO;
import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Insegnante con ID " + id + " non trovato"));
    }

    public List<Teacher> findByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName);
    }

    public List<Teacher> findByFirstNameAndLastName(String firstName, String lastName) {
        return teacherRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    public Teacher create(TeacherRequestDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setEmail(dto.getEmail());
        teacher.setPassword(dto.getPassword()); // Si consiglia di criptare la password

        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher update(Integer id, TeacherRequestDTO dto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Insegnante con ID " + id + " non trovato"));

        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setEmail(dto.getEmail());
        teacher.setPassword(dto.getPassword()); // Criptare la password

        return teacherRepository.save(teacher);
    }

    @Transactional
    public void delete(Integer id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Insegnante con ID " + id + " non trovato");
        }
        teacherRepository.deleteById(id);
    }
}
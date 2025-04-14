package com.example.demo.services;

import com.example.demo.dtos.SubjectRequestDTO;
import com.example.demo.dtos.SubjectResponseDTO;
import com.example.demo.entities.Subject;
import com.example.demo.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public List<SubjectResponseDTO> findAll() {
        return subjectRepository.findAll().stream()
                .map(subject -> modelMapper.map(subject, SubjectResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<SubjectResponseDTO> findById(Integer id) {
        return subjectRepository.findById(id)
                .map(subject -> modelMapper.map(subject, SubjectResponseDTO.class));
    }

    public List<SubjectResponseDTO> findByTeacherId(Integer teacherId) {
        return subjectRepository.findByTeacherId(teacherId).stream()
                .map(subject -> modelMapper.map(subject, SubjectResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public SubjectResponseDTO save(SubjectRequestDTO dto) {
        Subject subject = modelMapper.map(dto, Subject.class);
        Subject saved = subjectRepository.save(subject);
        return modelMapper.map(saved, SubjectResponseDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException("Materia con ID " + id + " non trovata");
        }
        subjectRepository.deleteById(id);
    }
}
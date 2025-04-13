package com.example.demo.mappers;

import com.example.demo.dtos.*;
import com.example.demo.entities.Exam;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamMapper {

    public ExamResponseDTO toDTO(Exam exam) {
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(exam.getId());
        dto.setExamDate(exam.getExamDate());
        dto.setGrade(exam.getGrade());

        dto.setStudent(toStudentDTO(exam.getStudent()));
        dto.setSubject(toSubjectDTO(exam.getSubject()));

        return dto;
    }

    private StudentExamDTO toStudentDTO(Student student) {
        return new StudentExamDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    private SubjectResponseDTO toSubjectDTO(Subject subject) {
        SubjectResponseDTO dto = new SubjectResponseDTO();
        dto.setId(subject.getId());
        dto.setSubjectName(subject.getSubjectName());
        return dto;
    }
}
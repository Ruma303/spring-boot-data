package com.example.demo.services;

import com.example.demo.entities.Exam;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subject;
import com.example.demo.repositories.ExamRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public ExamService(
            ExamRepository examRepository,
            StudentRepository studentRepository,
            SubjectRepository subjectRepository
    ) {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Page<Exam> findAll(Pageable pageable) {
        return examRepository.findAll(pageable);
    }

    public Optional<Exam> findById(Integer id) {
        return examRepository.findById(id);
    }

    public List<Exam> findByStudent(Integer studentId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        return studentOpt.map(examRepository::findByStudent)
                .orElse(Collections.emptyList());
    }

    public List<Exam> findBySubject(Integer subjectId) {
        Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);
        return subjectOpt.map(examRepository::findBySubject)
                .orElse(Collections.emptyList());
    }

    public List<Exam> findWithMinGrade(BigDecimal minGrade) {
        return examRepository.findExamsWithMinGrade(minGrade);
    }

    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    public void deleteById(Integer id) {
        examRepository.deleteById(id);
    }
}
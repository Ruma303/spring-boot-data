package com.example.demo.controllers;

    import com.example.demo.entities.Student;
    import com.example.demo.entities.StudentDetail;
    import com.example.demo.repositories.StudentDetailRepository;
    import com.example.demo.repositories.StudentRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/student-details")
    @RequiredArgsConstructor
    public class StudentDetailController {

        private final StudentDetailRepository studentDetailRepository;
        private final StudentRepository studentRepository;

        @GetMapping
        public List<StudentDetail> findAll() {
            return studentDetailRepository.findAll();
        }

        @GetMapping("/{id}")
        public Optional<StudentDetail> findById(@PathVariable Integer id) {
            return studentDetailRepository.findById(id);
        }

        @GetMapping("/address/{city}")
        public List<StudentDetail> findByAddressContainingCity(@PathVariable String city) {
            return studentDetailRepository.findByAddressContainingCity(city);
        }

        @PostMapping
        public StudentDetail save(@RequestBody StudentDetail detail) {
            // Recupera lo Student esistente dal DB per evitare errore di "detached entity"
            Integer studentId = detail.getStudent() != null ? detail.getStudent().getId() : null;

            if (studentId == null) {
                throw new IllegalArgumentException("Student id is required");
            }

            Optional<Student> studentOpt = studentRepository.findById(studentId);
            if (studentOpt.isEmpty()) {
                throw new IllegalArgumentException("Student with ID " + studentId + " not found");
            }

            Student managedStudent = studentOpt.get();
            detail.setStudent(managedStudent); // associa entità gestita
            return studentDetailRepository.save(detail);
        }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Integer id) {
            studentDetailRepository.deleteById(id);
        }
    }
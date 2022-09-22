package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get Requests
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Post Requests
    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentEmail.isPresent()) {
            throw new IllegalStateException("Email already in use or taken");
        }
        studentRepository.save(student);
    }

    // Delete Requests
    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException(
                "Student with ID " + studentId + " does not exist!");
        }
        studentRepository.deleteById(studentId);
    }
}

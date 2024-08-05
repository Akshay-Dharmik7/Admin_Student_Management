package com.example.student_admin_system.service;

import com.example.student_admin_system.entity.Student;
import com.example.student_admin_system.entity.Subject;
import com.example.student_admin_system.repository.StudentRepository;
import com.example.student_admin_system.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void enrollInSubject(Long studentId, Long subjectId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("Subject not found"));
        student.getSubjects().add(subject);
        studentRepository.save(student);
    }

    public List<Subject> getEnrolledSubjects(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        // Convert Set<Subject> to List<Subject>
        return new ArrayList<>(student.getSubjects());
    }
}

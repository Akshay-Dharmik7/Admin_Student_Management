package com.example.student_admin_system.controller;

import com.example.student_admin_system.entity.Student;
import com.example.student_admin_system.entity.Subject;
import com.example.student_admin_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/{id}/enroll/{subjectId}")
    public String enrollInSubject(@PathVariable Long id, @PathVariable Long subjectId) {
        studentService.enrollInSubject(id, subjectId);
        return "Student with ID " + id + " enrolled in subject " + subjectId;
    }

    @GetMapping("/{id}/subjects")
    public List<Subject> getEnrolledSubjects(@PathVariable Long id) {
        return studentService.getEnrolledSubjects(id);
    }
}

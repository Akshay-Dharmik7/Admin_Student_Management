package com.example.student_admin_system.controller;

import com.example.student_admin_system.entity.Student;
import com.example.student_admin_system.entity.Subject;
import com.example.student_admin_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return adminService.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject) {
        return adminService.createSubject(subject);
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return adminService.getAllSubjects();
    }
}

package com.example.student_admin_system.repository;

import com.example.student_admin_system.entity.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository example
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByName(String name);
}

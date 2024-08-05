package com.example.student_admin_system.service;

import com.example.student_admin_system.entity.Subject;
import java.util.List;

public interface SubjectService {
    Subject createSubject(Subject subject);
    Subject getSubjectById(Long id);
    List<Subject> getAllSubjects();
    Subject updateSubject(Long id, Subject subject);
    void deleteSubject(Long id);
}

package com.java.api.service;

import com.java.api.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(Long studentId);
    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
    List<Student> getStudents();
}

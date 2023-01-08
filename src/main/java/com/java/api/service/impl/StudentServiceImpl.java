package com.java.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.api.entity.Student;
import com.java.api.exception.StudentsNotFoundException;
import com.java.api.repository.StudentReposiory;
import com.java.api.service.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    StudentReposiory studentReposiory;

    @Override
    public Student getStudent(Long studentId) {
        Optional<Student> student = studentReposiory.findById(studentId);
        return unwrapStudent(student, studentId);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentReposiory.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentReposiory.deleteById(studentId);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>)studentReposiory.findAll();
    }
    
    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new StudentsNotFoundException(id);
    }
}

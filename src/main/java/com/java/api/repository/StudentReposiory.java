package com.java.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.api.entity.Student;

public interface StudentReposiory extends CrudRepository<Student, Long> {
    
}

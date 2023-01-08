package com.java.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.api.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
    
}

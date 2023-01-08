package com.java.api.service;

import com.java.api.entity.Course;

import java.util.List;

public interface CourseService {
    Course getCourse(Long couseId);
    Course saveCourse(Course course);
    void deleteCourse(Long courseId);
    List<Course> getCourses();
}

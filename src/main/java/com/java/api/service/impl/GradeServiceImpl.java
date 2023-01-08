package com.java.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.api.entity.Course;
import com.java.api.entity.Grade;
import com.java.api.entity.Student;
import com.java.api.exception.GradesNotFoundException;
import com.java.api.repository.CourseRepository;
import com.java.api.repository.GradeRepository;
import com.java.api.repository.StudentReposiory;
import com.java.api.service.GradeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService{

    GradeRepository gradeRepository;
    StudentReposiory studentReposiory;
    CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrappGrade(grade, courseId, studentId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentReposiory.findById(studentId), courseId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGradeScore(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        Grade unwrapGrade = unwrappGrade(grade, courseId, studentId);
        unwrapGrade.setScore(score);
        return gradeRepository.save(unwrapGrade);
    }
    

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getSudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>)gradeRepository.findAll();
    }
    
    static Grade unwrappGrade(Optional<Grade> entity, Long courseId, Long studentId) {
        if (entity.isPresent()) return entity.get();
        else throw new GradesNotFoundException(studentId, courseId);
    }
}

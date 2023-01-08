package com.java.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.java.api.entity.Grade;

import jakarta.transaction.TransactionScoped;

public interface GradeRepository extends CrudRepository<Grade, Long>{
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @TransactionScoped
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Grade> findByStudentId(Long studentId);
    List<Grade> findByCourseId(Long courseId);
}

package com.java.api.exception;

public class GradesNotFoundException extends RuntimeException{
    public GradesNotFoundException(Long studentId, Long courseId) {
        super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' does not exist in our records");
    }
}

package com.java.api.exception;

public class StudentsNotFoundException extends RuntimeException{
    public StudentsNotFoundException(Long id) {
        super("The student id '" + id + "' does not exist in our records");
    }
}

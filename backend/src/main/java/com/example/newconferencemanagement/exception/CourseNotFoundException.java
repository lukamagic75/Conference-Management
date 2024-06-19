package com.example.newconferencemanagement.exception;

/**
 * 自定义异常类，当课程未找到时抛出
 */
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}

package com.example.newconferencemanagement.exception;

/**
 * 自定义异常类，当部门未找到时抛出
 */
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}

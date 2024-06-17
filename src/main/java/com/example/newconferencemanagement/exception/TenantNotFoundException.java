package com.example.newconferencemanagement.exception;

/**
 * 自定义异常类，当租户未找到时抛出
 */
public class TenantNotFoundException extends RuntimeException {

    public TenantNotFoundException(String message) {
        super(message);
    }
}

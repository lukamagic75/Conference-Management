package com.example.newconferencemanagement.exception;

/**
 * 自定义异常类，当新闻未找到时抛出
 */
public class NewsNotFoundException extends RuntimeException {

    public NewsNotFoundException(String message) {
        super(message);
    }
}

package com.example.newconferencemanagement.exception;

/**
 * 自定义异常类，当会议未找到时抛出
 */
public class MeetingNotFoundException extends RuntimeException {

    public MeetingNotFoundException(String message) {
        super(message);
    }
}

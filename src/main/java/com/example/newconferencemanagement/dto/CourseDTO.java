package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.Course;

/**
 * 课程数据传输对象，用于在应用层和服务层之间传输数据
 */
public class CourseDTO {
    private Long id;
    private String courseName;
    private String description;
    private String author;
    private String status;
    private String coverImageUrl;
    private String videoUrl;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Course toEntity() {
        Course course = new Course();
        course.setId(this.id);
        course.setCourseName(this.courseName);
        course.setDescription(this.description);
        course.setAuthor(this.author);
        course.setStatus(this.status);
        course.setCoverImageUrl(this.coverImageUrl);
        course.setVideoUrl(this.videoUrl);
        return course;
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
        this.author = course.getAuthor();
        this.status = course.getStatus();
        this.coverImageUrl = course.getCoverImageUrl();
        this.videoUrl = course.getVideoUrl();
    }
}

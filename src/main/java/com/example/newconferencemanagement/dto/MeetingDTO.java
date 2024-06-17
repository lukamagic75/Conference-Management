package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.Meeting;

import java.time.LocalDateTime;

/**
 * 会议数据传输对象，用于在应用层和服务层之间传输数据
 */
public class MeetingDTO {
    private Long id;
    private String meetingName;
    private String description;
    private String organizer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private String coverImageUrl;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public Meeting toEntity() {
        Meeting meeting = new Meeting();
        meeting.setId(this.id);
        meeting.setMeetingName(this.meetingName);
        meeting.setDescription(this.description);
        meeting.setOrganizer(this.organizer);
        meeting.setStartTime(this.startTime);
        meeting.setEndTime(this.endTime);
        meeting.setStatus(this.status);
        meeting.setCoverImageUrl(this.coverImageUrl);
        return meeting;
    }

    public MeetingDTO(Meeting meeting) {
        this.id = meeting.getId();
        this.meetingName = meeting.getMeetingName();
        this.description = meeting.getDescription();
        this.organizer = meeting.getOrganizer();
        this.startTime = meeting.getStartTime();
        this.endTime = meeting.getEndTime();
        this.status = meeting.getStatus();
        this.coverImageUrl = meeting.getCoverImageUrl();
    }
}

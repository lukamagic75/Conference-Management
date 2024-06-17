package com.example.newconferencemanagement.controller;

import com.example.newconferencemanagement.dto.MeetingDTO;
import com.example.newconferencemanagement.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会议控制器类，处理会议相关的HTTP请求
 */
@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public List<MeetingDTO> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    public MeetingDTO getMeetingById(@PathVariable Long id) {
        return meetingService.getMeetingById(id);
    }

    @PostMapping
    public void createMeeting(@RequestBody MeetingDTO meetingDTO) {
        meetingService.createMeeting(meetingDTO);
    }

    @PutMapping("/{id}")
    public void updateMeeting(@PathVariable Long id, @RequestBody MeetingDTO meetingDTO) {
        meetingService.updateMeeting(id, meetingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
    }
}

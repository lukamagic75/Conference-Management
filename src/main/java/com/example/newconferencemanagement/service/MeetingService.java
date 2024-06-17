package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.MeetingDTO;
import com.example.newconferencemanagement.exception.MeetingNotFoundException;
import com.example.newconferencemanagement.model.Meeting;
import com.example.newconferencemanagement.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 会议服务类，处理会议相关的业务逻辑
 */
@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<MeetingDTO> getAllMeetings() {
        return meetingRepository.findAll().stream()
                .map(MeetingDTO::new)
                .collect(Collectors.toList());
    }

    public MeetingDTO getMeetingById(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new MeetingNotFoundException("Meeting not found"));
        return new MeetingDTO(meeting);
    }

    public void createMeeting(MeetingDTO meetingDTO) {
        meetingRepository.save(meetingDTO.toEntity());
    }

    public void updateMeeting(Long id, MeetingDTO meetingDTO) {
        if (meetingRepository.existsById(id)) {
            meetingRepository.save(meetingDTO.toEntity());
        } else {
            throw new MeetingNotFoundException("Meeting not found");
        }
    }

    public void deleteMeeting(Long id) {
        if (meetingRepository.existsById(id)) {
            meetingRepository.deleteById(id);
        } else {
            throw new MeetingNotFoundException("Meeting not found");
        }
    }
}

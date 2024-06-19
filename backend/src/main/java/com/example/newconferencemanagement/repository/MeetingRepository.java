package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 会议仓库接口，提供基本的CRUD操作
 */
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}

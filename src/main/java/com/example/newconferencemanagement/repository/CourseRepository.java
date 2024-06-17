package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 课程仓库接口，提供基本的CRUD操作
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseNameContaining(String courseName);
    List<Course> findByAuthorContaining(String author);
}

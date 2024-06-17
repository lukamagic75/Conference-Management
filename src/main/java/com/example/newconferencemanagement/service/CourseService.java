package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.CourseDTO;
import com.example.newconferencemanagement.exception.CourseNotFoundException;
import com.example.newconferencemanagement.model.Course;
import com.example.newconferencemanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 课程服务类，处理课程相关的业务逻辑
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));
        return new CourseDTO(course);
    }

    public void createCourse(CourseDTO courseDTO) {
        courseRepository.save(courseDTO.toEntity());
    }

    public void updateCourse(Long id, CourseDTO courseDTO) {
        if (courseRepository.existsById(id)) {
            courseRepository.save(courseDTO.toEntity());
        } else {
            throw new CourseNotFoundException("Course not found");
        }
    }

    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new CourseNotFoundException("Course not found");
        }
    }
}

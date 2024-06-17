package com.example.newconferencemanagement.controller;

import com.example.newconferencemanagement.dto.CourseDTO;
import com.example.newconferencemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程控制器类，处理课程相关的HTTP请求
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

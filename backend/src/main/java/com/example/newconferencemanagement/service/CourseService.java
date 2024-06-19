package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.CourseDTO;
import com.example.newconferencemanagement.exception.CourseNotFoundException;
import com.example.newconferencemanagement.model.Course;
import com.example.newconferencemanagement.repository.CourseRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public void exportCoursesToExcel(HttpServletResponse response) throws IOException {
        List<Course> courses = courseRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Courses");

        Row headerRow = sheet.createRow(0);
        String[] columnHeaders = {"课程名称", "课程简介", "课程排序", "课程作者", "课程封面", "课程视频"};
        for (int i = 0; i < columnHeaders.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnHeaders[i]);
        }

        int rowNum = 1;
        for (Course course : courses) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(course.getCourseName());
            row.createCell(1).setCellValue(course.getDescription());
            row.createCell(2).setCellValue(course.getStatus());
            row.createCell(3).setCellValue(course.getAuthor());
            row.createCell(4).setCellValue(course.getCoverImageUrl());
            row.createCell(5).setCellValue(course.getVideoUrl());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=courses.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

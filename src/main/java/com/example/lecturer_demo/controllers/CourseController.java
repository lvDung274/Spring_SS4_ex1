package com.example.lecturer_demo.controllers;

import com.example.lecturer_demo.dto.ApiResponse;
import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/app/course")
public class CourseController {
    private CourseService courseService;

    // Constructor Injection
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        ApiResponse<List<Course>> response = new ApiResponse<>(true, "Lấy danh sách khóa học thành công", courses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            ApiResponse<Course> response = new ApiResponse<>(true, "Lấy thông tin khóa học thành công", course);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Course> response = new ApiResponse<>(false, "Không tìm thấy khóa học", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        Course created = courseService.createCourse(course);
        ApiResponse<Course> response = new ApiResponse<>(true, "Tạo mới khóa học thành công", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updated = courseService.updateCourse(id, course);
        if (updated != null) {
            ApiResponse<Course> response = new ApiResponse<>(true, "Cập nhật khóa học thành công", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Course> response = new ApiResponse<>(false, "Không tìm thấy khóa học để cập nhật", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable Long id) {
        Course deleted = courseService.deleteCourseById(id);
        if (deleted != null) {
            ApiResponse<Course> response = new ApiResponse<>(true, "Xóa khóa học thành công", deleted);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Course> response = new ApiResponse<>(false, "Không tìm thấy khóa học để xóa", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}

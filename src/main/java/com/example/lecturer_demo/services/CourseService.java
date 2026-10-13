package com.example.lecturer_demo.services;

import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.repositories.CourseRepository;
import com.example.lecturer_demo.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    // Constructor Injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.create(course);
    }

    public Course updateCourse(Long id, Course course) {
        return courseRepository.update(id, course);
    }

    public Course deleteCourseById(Long id) {
        return courseRepository.deleteById(id);
    }

}

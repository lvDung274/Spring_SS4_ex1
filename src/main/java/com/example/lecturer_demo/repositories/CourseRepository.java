package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    List<Course>  courses = new ArrayList<>(
            Arrays.asList(
                    new Course(101L, "Lập trình Java cơ bản", "ACTIVE", 1L),
                    new Course(102L, "Spring Boot từ A-Z", "ACTIVE", 2L)
            )
    );
    public List<Course>  findAll() {
        return courses;
    }
    public Optional<Course> findById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(Long id, Course updatedCourse) {
        Course existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));
        existing.setTitle(updatedCourse.getTitle());
        existing.setStatus(updatedCourse.getStatus());
        existing.setInstructorId(updatedCourse.getInstructorId());
        return existing;
    }

    public Course deleteById(Long id) {
        Course existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));
        courses.remove(existing);
        return existing;
    }
}

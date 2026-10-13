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
        Optional<Course> existing = findById(id);
        if (existing.isPresent()) {
            Course course = existing.get();
            course.setTitle(updatedCourse.getTitle());
            course.setStatus(updatedCourse.getStatus());
            course.setInstructorId(updatedCourse.getInstructorId());
            return course;
        }
        return null;
    }

    public Course deleteById(Long id) {
        Optional<Course> existing = findById(id);
        if (existing.isPresent()) {
            Course course = existing.get();
            courses.remove(course);
            return course;
        }
        return null;
    }
}

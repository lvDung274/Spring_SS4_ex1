package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}

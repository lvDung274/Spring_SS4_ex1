package com.example.lecturer_demo.dto;

import com.example.lecturer_demo.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDetailResponse {
    private Long id;
    private String name;
    private String email;
    private List<Course> activeCoursesWithEnrollments;
}

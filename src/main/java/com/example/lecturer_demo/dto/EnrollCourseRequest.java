package com.example.lecturer_demo.dto;

import lombok.Data;

@Data
public class EnrollCourseRequest {
    private Long id;
    private String studentName;
    private Long courseId;
}

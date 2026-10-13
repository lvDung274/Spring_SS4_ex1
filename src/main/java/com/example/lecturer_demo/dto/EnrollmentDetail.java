package com.example.lecturer_demo.dto;

import com.example.lecturer_demo.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetail {
    private long id;
    private String studentName;
    private Course course;
}

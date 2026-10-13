package com.example.lecturer_demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Enrollment {
    private Long id;
    private String studentName;
    private Long courseId;
}

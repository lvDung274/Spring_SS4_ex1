package com.example.lecturer_demo.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "courses", schema = "public")
@Entity
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CourseStatus status; //Đổi kiểu từ String sang CourseStatus


    @Column( nullable = false)
    private Long instructorId;
}

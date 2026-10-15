package com.example.lecturer_demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructors", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(  nullable = false , length = 100)
    private String name;

    @Column(nullable = false)
    private String email;
}

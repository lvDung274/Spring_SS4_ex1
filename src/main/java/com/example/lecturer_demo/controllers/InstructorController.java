package com.example.lecturer_demo.controllers;

import com.example.lecturer_demo.models.Instructor;
import com.example.lecturer_demo.services.InstructorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/app/instructor")
public class InstructorController {
    private InstructorService instructorService;

    // Constructor Injection
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorService.getAllInstructors();
    }
}

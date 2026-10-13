package com.example.lecturer_demo.controllers;

import com.example.lecturer_demo.dto.ApiResponse;
import com.example.lecturer_demo.models.Instructor;
import com.example.lecturer_demo.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        try {
            List<Instructor> instructors = instructorService.getAllInstructors();
            return ResponseEntity.ok(new ApiResponse<>(true, "Fetched Successfully", instructors));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable long id) {
        try {
            Instructor instructor = instructorService.getInstructorById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Đã truy xuất thành công", instructor));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        try {
            Instructor created = instructorService.createInstructor(instructor);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Đã truy xuất thành công", created));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable long id, @RequestBody Instructor instructor) {
        try {
            Instructor updated = instructorService.updateInstructor(id, instructor);
            return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhập ok", updated));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable long id) {
        try {
            Instructor deleted = instructorService.deleteInstructorById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Xóa ok", deleted));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }
}

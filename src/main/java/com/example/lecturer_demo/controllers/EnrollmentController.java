package com.example.lecturer_demo.controllers;

import com.example.lecturer_demo.dto.ApiResponse;
import com.example.lecturer_demo.models.Enrollment;
import com.example.lecturer_demo.services.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/app/enrollment")
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    // Constructor Injection
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        try {
            List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
            return ResponseEntity.ok(new ApiResponse<>(true, "Đã truy xuất thành công", enrollments));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable long id) {
        try {
            Enrollment enrollment = enrollmentService.getEnrollmentById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Đã truy xuất thành công", enrollment));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
        try {
            Enrollment created = enrollmentService.createEnrollment(enrollment);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Đã tạo thanhf công", created));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable long id, @RequestBody Enrollment enrollment) {
        try {
            Enrollment updated = enrollmentService.updateEnrollment(id, enrollment);
            return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhập ok", updated));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollmentById(@PathVariable long id) {
        try {
            Enrollment deleted = enrollmentService.deleteEnrollmentById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Xóa ok", deleted));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }
}

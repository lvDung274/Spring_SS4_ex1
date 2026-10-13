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
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        ApiResponse<List<Enrollment>> response = new ApiResponse<>(true, "Lấy danh sách đăng ký thành công", enrollments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment != null) {
            ApiResponse<Enrollment> response = new ApiResponse<>(true, "Lấy thông tin đăng ký thành công", enrollment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Enrollment> response = new ApiResponse<>(false, "Không tìm thấy thông tin đăng ký", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment created = enrollmentService.createEnrollment(enrollment);
        ApiResponse<Enrollment> response = new ApiResponse<>(true, "Tạo mới lượt đăng ký thành công", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment updated = enrollmentService.updateEnrollment(id, enrollment);
        if (updated != null) {
            ApiResponse<Enrollment> response = new ApiResponse<>(true, "Cập nhật lượt đăng ký thành công", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Enrollment> response = new ApiResponse<>(false, "Không tìm thấy lượt đăng ký để cập nhật", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollmentById(@PathVariable Long id) {
        Enrollment deleted = enrollmentService.deleteEnrollmentById(id);
        if (deleted != null) {
            ApiResponse<Enrollment> response = new ApiResponse<>(true, "Xóa lượt đăng ký thành công", deleted);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Enrollment> response = new ApiResponse<>(false, "Không tìm thấy lượt đăng ký để xóa", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}

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
        List<Instructor> instructors = instructorService.getAllInstructors();
        ApiResponse<List<Instructor>> response = new ApiResponse<>(true, "Lấy danh sách giảng viên thành công", instructors);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Lấy thông tin giảng viên thành công", instructor);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Không tìm thấy giảng viên", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        Instructor created = instructorService.createInstructor(instructor);
        ApiResponse<Instructor> response = new ApiResponse<>(true, "Tạo mới giảng viên thành công", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updated = instructorService.updateInstructor(id, instructor);
        if (updated != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Cập nhật giảng viên thành công", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Không tìm thấy giảng viên để cập nhật", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable Long id) {
        Instructor deleted = instructorService.deleteInstructorById(id);
        if (deleted != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Xóa giảng viên thành công", deleted);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Không tìm thấy giảng viên để xóa", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

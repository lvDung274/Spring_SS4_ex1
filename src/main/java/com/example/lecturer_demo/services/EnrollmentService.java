package com.example.lecturer_demo.services;

import com.example.lecturer_demo.models.Enrollment;
import com.example.lecturer_demo.repositories.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    // Constructor Injection
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    public Enrollment getEnrollmentById(long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin đăng ký"));
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.create(enrollment);
    }

    public Enrollment updateEnrollment(long id, Enrollment enrollment) {
        return enrollmentRepository.update(id, enrollment);
    }

    public Enrollment deleteEnrollmentById(long id) {
        return enrollmentRepository.deleteById(id);
    }
}

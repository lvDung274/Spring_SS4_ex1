package com.example.lecturer_demo.services;

import com.example.lecturer_demo.dto.EnrollCourseRequest;
import com.example.lecturer_demo.dto.EnrollmentDetail;
import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.models.Enrollment;
import com.example.lecturer_demo.repositories.CourseRepository;
import com.example.lecturer_demo.repositories.EnrollmentRepository;
import com.example.lecturer_demo.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    // Constructor Injection
    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             CourseRepository courseRepository,
                             InstructorRepository instructorRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
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

    public EnrollmentDetail enrollCourse(EnrollCourseRequest request) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Khóa học không tìm thấy"));

        if (!"ACTIVE".equalsIgnoreCase(course.getStatus().name())) {
            throw new RuntimeException("Khóa học hiện không mở đăng ký");
        }

        instructorRepository.findById(course.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên của khóa học này."));

        Enrollment newEnrollment = new Enrollment(request.getId(), request.getStudentName(), request.getCourseId());
        enrollmentRepository.create(newEnrollment);

        return new EnrollmentDetail(newEnrollment.getId(), newEnrollment.getStudentName(), course);
    }
}

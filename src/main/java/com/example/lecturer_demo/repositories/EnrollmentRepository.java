package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class EnrollmentRepository {
    List<Enrollment> enrollments = new ArrayList<>(
            Arrays.asList(
                    new Enrollment(1001L, "Lê Văn Nam", 101L),
                    new Enrollment(1002L, "Phạm Thị Hoa", 102L)
            )
    );
    public List<Enrollment> findAll() {
        return enrollments;
    }
    public Optional<Enrollment> findById(long id) {
        return enrollments.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(long id, Enrollment updatedEnrollment) {
        Enrollment existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin đăng ký"));
        existing.setStudentName(updatedEnrollment.getStudentName());
        existing.setCourseId(updatedEnrollment.getCourseId());
        return existing;
    }

    public Enrollment deleteById(long id) {
        Enrollment existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin đăng ký"));
        enrollments.remove(existing);
        return existing;
    }
}

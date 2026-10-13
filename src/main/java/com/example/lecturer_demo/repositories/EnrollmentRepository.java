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
    public Optional<Enrollment> findById(Long id) {
        return enrollments.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment updatedEnrollment) {
        Optional<Enrollment> existing = findById(id);
        if (existing.isPresent()) {
            Enrollment enrollment = existing.get();
            enrollment.setStudentName(updatedEnrollment.getStudentName());
            enrollment.setCourseId(updatedEnrollment.getCourseId());
            return enrollment;
        }
        return null;
    }

    public Enrollment deleteById(Long id) {
        Optional<Enrollment> existing = findById(id);
        if (existing.isPresent()) {
            Enrollment enrollment = existing.get();
            enrollments.remove(enrollment);
            return enrollment;
        }
        return null;
    }
}

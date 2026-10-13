package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}

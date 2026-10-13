package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository {
    List<Instructor>  instructors = new ArrayList<>(
            Arrays.asList(
                    new Instructor(1L, "Nguyễn Văn A", "a.nguyen@example.com"),
                    new Instructor(2L, "Trần Thị B", "b.tran@example.com"),
                    new Instructor(3L, "Nguyễn Văn c", "uc.nguyen@example.com")
            )
    );
    public List<Instructor> findAll() {
        return instructors;
    }

    public Optional<Instructor> findById(long id) {
        return instructors.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(long id, Instructor updatedInstructor) {
        Instructor existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên"));
        existing.setName(updatedInstructor.getName());
        existing.setEmail(updatedInstructor.getEmail());
        return existing;
    }

    public Instructor deleteById(long id) {
        Instructor existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên"));
        instructors.remove(existing);
        return existing;
    }

}

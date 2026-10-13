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

    public Optional<Instructor> findById(Long id) {
        return instructors.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor updatedInstructor) {
        Optional<Instructor> existing = findById(id);
        if (existing.isPresent()) {
            Instructor instructor = existing.get();
            instructor.setName(updatedInstructor.getName());
            instructor.setEmail(updatedInstructor.getEmail());
            return instructor;
        }
        return null;
    }

    public Instructor deleteById(Long id) {
        Optional<Instructor> existing = findById(id);
        if (existing.isPresent()) {
            Instructor instructor = existing.get();
            instructors.remove(instructor);
            return instructor;
        }
        return null;
    }

}

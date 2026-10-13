package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}

package com.example.lecturer_demo.services;

import com.example.lecturer_demo.models.Instructor;
import com.example.lecturer_demo.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InstructorService {
    private final InstructorRepository instructorRepository;

    // Constructor Injection
   public  InstructorService(InstructorRepository instructorRepository) {
       this.instructorRepository = instructorRepository;
   }
   public List<Instructor> getAllInstructors() {
       return instructorRepository.findAll();
   }
    public Instructor getInstructorById(long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên"));
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.create(instructor);
    }

    public Instructor updateInstructor(long id, Instructor instructor) {
        return instructorRepository.update(id, instructor);
    }

    public Instructor deleteInstructorById(long id) {
        return instructorRepository.deleteById(id);
    }
}

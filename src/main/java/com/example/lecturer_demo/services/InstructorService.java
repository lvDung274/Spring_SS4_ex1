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
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.create(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorRepository.update(id, instructor);
    }

    public Instructor deleteInstructorById(Long id) {
        return instructorRepository.deleteById(id);
    }
}

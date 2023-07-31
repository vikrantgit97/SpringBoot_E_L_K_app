package com.elk.service;

import com.elk.entity.Student;
import com.elk.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" id not found "));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" id not found "));
        studentRepository.deleteById(id);
    }
}

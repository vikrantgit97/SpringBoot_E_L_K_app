package com.elk.service;

import com.elk.entity.Student;
import com.elk.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getStudentById(Byte id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Byte id) {
        studentRepository.deleteById(id);
    }
}

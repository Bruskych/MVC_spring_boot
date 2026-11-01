package com.ukf.spring_mvc.service;

import com.ukf.spring_mvc.entity.Student;
import com.ukf.spring_mvc.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Študent nenájdený"));
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Študent nenájdený");
        }
        studentRepository.deleteById(id);
    }
}

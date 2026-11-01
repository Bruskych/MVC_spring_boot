package com.ukf.spring_mvc.repository;

import com.ukf.spring_mvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
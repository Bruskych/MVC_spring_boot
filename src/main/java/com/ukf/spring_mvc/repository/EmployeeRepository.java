package com.ukf.spring_mvc.repository;

import com.ukf.spring_mvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

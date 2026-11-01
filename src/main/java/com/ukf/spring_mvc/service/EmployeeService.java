package com.ukf.spring_mvc.service;

import com.ukf.spring_mvc.entity.Employee;
import com.ukf.spring_mvc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Zamestnanec nenájdený"));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}

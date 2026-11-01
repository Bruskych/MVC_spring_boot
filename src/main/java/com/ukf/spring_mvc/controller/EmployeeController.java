package com.ukf.spring_mvc.controller;

import com.ukf.spring_mvc.entity.Employee;
import com.ukf.spring_mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Value("${employee.job.titles}")
    private List<String> jobTitles;

    @Value("${employee.job.types}")
    private List<String> jobTypes;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/employees";
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employees/view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("jobTypes", jobTypes);
        return "employees/form";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setId(null);
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("jobTypes", jobTypes);
        return "employees/form";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}

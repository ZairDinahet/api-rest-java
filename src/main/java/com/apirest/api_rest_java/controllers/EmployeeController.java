package com.apirest.api_rest_java.controllers;

import com.apirest.api_rest_java.models.entities.Employee;
import com.apirest.api_rest_java.repositories.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with Id " + id + " not found"));
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody @NotNull Employee employee) {
        Employee employeeFound = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with Id " + id + " not found"));

        employeeFound.setName(employee.getName());
        employeeFound.setLastName(employee.getLastName());
        employeeFound.setPosition(employee.getPosition());
        employeeFound.setEmail(employee.getEmail());
        employeeFound.setAddress(employee.getAddress());
        employeeFound.setPhone(employee.getPhone());

        return employeeRepository.save(employeeFound);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee employeeFound = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with Id " + id + " not found"));

        employeeRepository.delete(employeeFound);
        return "Employee with Id " + id + " deleted";
    }
}

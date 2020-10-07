package com.springbackend.controllers;


import com.springbackend.exceptions.ResourceNotFoundException;
import com.springbackend.models.Employee;
import com.springbackend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    // get employee by id

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("An employee with id: %d does not exist!", id)));

        return ResponseEntity.ok(employee);
    }
}

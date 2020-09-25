package com.springbackend.controllers;


import com.springbackend.models.Employee;
import com.springbackend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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
}

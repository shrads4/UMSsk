package com.ums.controller;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger log = LogManager.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/salary-range")
    public int getCountOfEmployeesInSalaryRange(@RequestParam Double lowerRange, @RequestParam Double upperRange) {
        log.info("Fetching count of employees within salary range: {} to {}", lowerRange, upperRange);
        return employeeService.getCountOfEmployeesInSalaryRange(lowerRange, upperRange);
    }
}

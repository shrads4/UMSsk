package com.ums.service;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.entity.OfficeBranch;
import com.ums.exception.CustomException;
import com.ums.repository.IEmployee;
import com.ums.repository.IOfficeBranch;
import com.ums.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.ums.service.OfficeBranchService;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private IEmployee employeeRepository;

    @Autowired
    private IOfficeBranch officeBranchRepository;

    public int getCountOfEmployeesInSalaryRange(Double lowerRange, Double upperRange) {
        return employeeRepository.countEmployeesInSalaryRange(lowerRange, upperRange);
    }
    public Employee createEmployee(EmployeeDto employee) {
        Optional<OfficeBranch> officeBranch = Optional.ofNullable(employee.getOfficeBranchId()).flatMap(officeBranchRepository::findById);

        Employee employee1 = new Employee();
        officeBranch.ifPresent(employee1::setOfficeBranch);

        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setSalary(employee.getSalary());

        return employeeRepository.save(employee1);
    }
}
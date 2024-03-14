package com.ums.service;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.entity.OfficeBranch;
import com.ums.exception.CustomException;
import com.ums.repository.IEmployee;
import com.ums.repository.IOfficeBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployee employeeRepository;

    @Autowired
    private IOfficeBranch officeBranchRepository;

    public int getCountOfEmployeesInSalaryRange(Double lowerRange, Double upperRange) {
        return employeeRepository.countEmployeesInSalaryRange(lowerRange, upperRange);
    }

    public Employee createEmployee(EmployeeDto employeeDto) {


        // Check if an employee with the same name and phone number already exists
        if (employeeRepository.existsByEmployeeNameAndPhoneNumber(employeeDto.getEmployeeName(), employeeDto.getPhoneNumber())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Employee with the same name and phone number already exists");
        }

        Optional<OfficeBranch> officeBranch = Optional.ofNullable(employeeDto.getOfficeBranchId())
                .flatMap(officeBranchRepository::findById);

        Employee employee1 = new Employee();
        officeBranch.ifPresent(employee1::setOfficeBranch);

        employee1.setEmployeeName(employeeDto.getEmployeeName());
        employee1.setPhoneNumber(employeeDto.getPhoneNumber());
        employee1.setSalary(employeeDto.getSalary());

        return employeeRepository.save(employee1);
    }
}

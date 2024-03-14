package com.ums.repository;

import com.ums.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends JpaRepository<Employee, String> {

    @Query(value = "SELECT COUNT(*) FROM Employee WHERE salary BETWEEN :lowerRange AND :upperRange", nativeQuery = true)
    int countEmployeesInSalaryRange(Double lowerRange, Double upperRange);

    boolean existsByEmployeeNameAndPhoneNumber(String employeeName, String phoneNumber);
}

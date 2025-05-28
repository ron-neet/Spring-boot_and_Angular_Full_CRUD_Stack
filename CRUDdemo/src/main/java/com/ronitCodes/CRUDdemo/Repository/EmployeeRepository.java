package com.ronitCodes.CRUDdemo.Repository;

import com.ronitCodes.CRUDdemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Haha! no need to write code lol.....!!!
}

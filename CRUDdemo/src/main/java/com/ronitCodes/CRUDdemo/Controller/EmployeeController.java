package com.ronitCodes.CRUDdemo.Controller;

import com.ronitCodes.CRUDdemo.Exception.ResourceNotFoundException;
import com.ronitCodes.CRUDdemo.Model.Employee;
import com.ronitCodes.CRUDdemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all Employees Api
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Create the employee rest Api
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // Get employee by id Rest API
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id")long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new
                ResourceNotFoundException("Employee not found for this id :: " + id));

        return ResponseEntity.ok(employee);
    }

    //Update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(
    @PathVariable(value = "id")long id, @RequestBody Employee employeeDetails){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new
                ResourceNotFoundException("Employee not found for this id :: " + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee Rest API
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(value = "id")long id){
        Employee delEmployee = employeeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + id));
        employeeRepository.delete(delEmployee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}

package com.restcurd.controller;

import com.restcurd.entity.EmployeeEntity;
import com.restcurd.exception.StudentNotFoundException;
import com.restcurd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable long employeeId){
        EmployeeEntity employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new StudentNotFoundException("Employee not found " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee){
        employee.setId(0L);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable long employeeId){
        EmployeeEntity employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new StudentNotFoundException("Employee not found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}

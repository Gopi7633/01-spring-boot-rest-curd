package com.restcurd.service;

import com.restcurd.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> findAll();

    EmployeeEntity findById(long id);

    EmployeeEntity save(EmployeeEntity employee);

    void deleteById(long id);
}

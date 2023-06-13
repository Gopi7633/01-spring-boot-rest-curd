package com.restcurd.dao;

import com.restcurd.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeEntity> findAll();

    EmployeeEntity findById(long id);

    EmployeeEntity save(EmployeeEntity employee);

    void deleteById(long id);
}

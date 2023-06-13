package com.restcurd.service;

import com.restcurd.dao.EmployeeDAO;
import com.restcurd.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public EmployeeEntity findById(long id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeDAO.deleteById(id);
    }
}

package com.restcurd.dao;

import com.restcurd.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<EmployeeEntity> findAll() {
        TypedQuery<EmployeeEntity> employees = entityManager.createQuery("from EmployeeEntity",EmployeeEntity.class);
        List<EmployeeEntity> employeeEntities = employees.getResultList();
        return employeeEntities;
    }

    @Override
    public EmployeeEntity findById(long id) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class,id);
        return employee;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        EmployeeEntity saveEmployee = entityManager.merge(employee);
        return saveEmployee;
    }

    @Override
    public void deleteById(long id) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class,id);
        entityManager.remove(employee);
    }
}

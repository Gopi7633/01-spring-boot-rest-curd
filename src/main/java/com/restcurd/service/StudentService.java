package com.restcurd.service;


import com.restcurd.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAll();

    StudentEntity findById(long id);

    StudentEntity save(StudentEntity student);

    void deleteById(long id);
}

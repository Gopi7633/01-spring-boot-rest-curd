package com.restcurd.service;

import com.restcurd.entity.StudentEntity;
import com.restcurd.exception.StudentNotFoundException;
import com.restcurd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();

    }

    @Override
    public StudentEntity findById(long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);

        StudentEntity student = null;

        if (studentEntity.isPresent()){
            student = studentEntity.get();
        }else {
            throw new StudentNotFoundException("student not found " + id);
        }

        return student;
    }


    @Override
    public StudentEntity save(StudentEntity employee) {
        return studentRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }
}

package com.restcurd.controller;

import com.restcurd.entity.StudentEntity;
import com.restcurd.exception.StudentNotFoundException;
import com.restcurd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
public class StudentDataJpaController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public List<StudentEntity> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public StudentEntity getStudentById(@PathVariable long studentId){
        StudentEntity employee = studentService.findById(studentId);
        if (employee == null){
            throw new StudentNotFoundException("Employee not found " + studentId);
        }
        return employee;
    }

    @PostMapping("/students")
    public StudentEntity saveStudent(@RequestBody StudentEntity student){
        student.setId(0L);
        return studentService.save(student);
    }

    @PutMapping("/students")
    public StudentEntity updateStudent(@RequestBody StudentEntity student){
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteEmployeeById(@PathVariable long studentId){
        StudentEntity student = studentService.findById(studentId);
        if (student == null){
            throw new StudentNotFoundException("Student not found " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted student id - " + studentId;
    }
}

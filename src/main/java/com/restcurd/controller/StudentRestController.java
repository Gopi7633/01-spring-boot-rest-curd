package com.restcurd.controller;

import com.restcurd.entity.Student;
import com.restcurd.exception.StudentErrorResponse;
import com.restcurd.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Gopi","Thangavel",27));
        studentList.add(new Student("Prathap","Ramesh",30));
        studentList.add(new Student("Srini","Vasan",26));
        studentList.add(new Student("Vel","Murugan",29));
    }


    @GetMapping("/students")
    private List<Student> getAllStudents(){
        return studentList;
    }

    @GetMapping("/student/{studentId}")
    private Student getStudentById(@PathVariable int studentId){

        if ((studentId >= studentList.size() || (studentId < 0))){
          //  throw new RuntimeException("student id not found " + studentId);
            throw new StudentNotFoundException("student id not found " + studentId);
        }

        return studentList.get(studentId);
    }
}

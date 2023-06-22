package com.restcurd.controller;

import com.restcurd.entity.Instructor;
import com.restcurd.entity.InstructorDetail;
import com.restcurd.entity.StudentEntity;
import com.restcurd.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/instructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.saveInstrctor(instructor);
    }

    @GetMapping("/instructor/{instructorId}")
    public Instructor getInstructor(@PathVariable long instructorId){
        return instructorService.getInstrctor(instructorId);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public String deleteInstructor(@PathVariable long instructorId){
        return instructorService.deleteInstructor(instructorId);
    }

    @GetMapping("/instructorDetail/{instructorDetailId}")
    public InstructorDetail getInstructorDetail(@PathVariable long instructorDetailId){
        return instructorService.getInstructorDetail(instructorDetailId);
    }

    @DeleteMapping("/instructorDetail/{instructorDetailId}")
    public String deleteInstructorDetail(@PathVariable long instructorDetailId){
        return instructorService.deleteInstructorDetail(instructorDetailId);
    }


}

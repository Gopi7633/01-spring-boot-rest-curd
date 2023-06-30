package com.restcurd.controller;

import com.restcurd.dto.InstructorDetailResponse;
import com.restcurd.dto.InstructorDto;
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

    //Uni-Direction Mapping - One to One
    @PostMapping("/instructor")
    public Instructor saveInstructor(@RequestBody InstructorDto instructor){
        return instructorService.saveInstrctor(instructor);
    }

    @GetMapping("/instructor/{instructorId}")
    public InstructorDto getInstructor(@PathVariable Long instructorId){
        return instructorService.getInstrctor(instructorId);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public String deleteInstructor(@PathVariable long instructorId){
        return instructorService.deleteInstructor(instructorId);
    }

    //Bi-Direction Mapping One to One
    @GetMapping("/instructorDetail/{instructorDetailId}")
    public InstructorDetailResponse getInstructorDetail(@PathVariable long instructorDetailId){
        return instructorService.getInstructorDetail(instructorDetailId);
    }

    @DeleteMapping("/instructorDetail/{instructorDetailId}")
    public String deleteInstructorDetail(@PathVariable long instructorDetailId){
        return instructorService.deleteInstructorDetail(instructorDetailId);
    }

   /* @PostMapping("/instructor/course")
    public Instructor saveInstructorAndCourse(@RequestBody Instructor instructor){
        return instructorService.saveInstructorAndCourse(instructor);
    }*/


}

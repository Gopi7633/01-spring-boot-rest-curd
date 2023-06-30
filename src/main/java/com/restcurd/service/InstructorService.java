package com.restcurd.service;

import com.restcurd.dto.InstructorDetailResponse;
import com.restcurd.dto.InstructorDto;
import com.restcurd.entity.Instructor;
import com.restcurd.entity.InstructorDetail;

public interface InstructorService {
    Instructor saveInstrctor(InstructorDto instructor);

    InstructorDto getInstrctor(Long instructorId);

    String deleteInstructor(long instructorId);

    InstructorDetailResponse getInstructorDetail(long instructorDetailId);
    String deleteInstructorDetail(long instructorDetailId);

//    Instructor saveInstructorAndCourse(Instructor instructor);
}

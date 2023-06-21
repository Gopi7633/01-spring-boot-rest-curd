package com.restcurd.service;

import com.restcurd.entity.Instructor;
import com.restcurd.entity.InstructorDetail;

public interface InstructorService {
    Instructor saveInstrctor(Instructor instructor);

    Instructor getInstrctor(long instructorId);

    String deleteInstructor(long instructorId);

/*    InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail);

    InstructorDetail getInstructorDetail(long instructorDetailId);

    String deleteInstructorDetail(long instructorDetailId);*/
}

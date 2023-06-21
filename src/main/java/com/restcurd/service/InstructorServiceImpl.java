package com.restcurd.service;

import com.restcurd.entity.Instructor;
import com.restcurd.entity.InstructorDetail;
import com.restcurd.repository.InstructorDetailRepository;
import com.restcurd.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;

    @Override
    public Instructor saveInstrctor(Instructor instructor) {
        Instructor savedInstructor = instructorRepository.save(instructor);
        return savedInstructor;
    }

    @Override
    public Instructor getInstrctor(long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById((int) instructorId);
        Instructor instructor = instructorOptional.get();
        return instructor;
    }

    @Override
    public String deleteInstructor(long instructorId) {
        /*Optional<Instructor> instructorOptional = instructorRepository.findById((int) instructorId);
        Instructor instructor = instructorOptional.get();*/
        instructorRepository.deleteById((int) instructorId);
        return "Instructor is deleted successfully! instructorId is : " + instructorId;
    }

/*    @Transactional
    @Override
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail) {
        InstructorDetail savedInstructorDetail = instructorDetailRepository.save(instructorDetail);
        return savedInstructorDetail;
    }

    @Override
    public InstructorDetail getInstructorDetail(long instructorDetailId) {
        Optional<InstructorDetail> instructorDetailOptional = instructorDetailRepository.findById(instructorDetailId);
        InstructorDetail instructorDetail = instructorDetailOptional.get();
        return instructorDetail;
    }

    @Override
    public String deleteInstructorDetail(long instructorDetailId) {
        instructorDetailRepository.deleteById(instructorDetailId);
        return "InstructorDetail is deleted successfully! instructorDetailId is : " + instructorDetailId;
    }*/
}

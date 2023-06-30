package com.restcurd.service;

import com.restcurd.dto.InstructorDetailResponse;
import com.restcurd.dto.InstructorDetailsDto;
import com.restcurd.dto.InstructorDto;
import com.restcurd.dto.InstructorResponse;
import com.restcurd.entity.Course;
import com.restcurd.entity.Instructor;
import com.restcurd.entity.InstructorDetail;
import com.restcurd.repository.InstructorDetailRepository;
import com.restcurd.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Instructor saveInstrctor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();

        instructor.setFirstName(instructorDto.getFirstName());
        instructor.setLastName(instructorDto.getLastName());
        instructor.setEmail(instructorDto.getEmail());

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructorDto.getInstructorDetails().getHobby());
        instructorDetail.setYoutubeChannel(instructorDto.getInstructorDetails().getYoutubeChannel());

        instructor.setInstructorDetail(instructorDetail);


        Instructor savedInstructor = instructorRepository.save(instructor);
        return savedInstructor;
    }

    @Override
    public InstructorDto getInstrctor(Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        Instructor instructor = instructorOptional.get();

        InstructorDto instructorDto = new InstructorDto();
        instructorDto.setFirstName(instructor.getFirstName());
        instructorDto.setLastName(instructor.getLastName());
        instructorDto.setEmail(instructor.getEmail());

        InstructorDetailsDto instructorDetailsDto = new InstructorDetailsDto();
        instructorDetailsDto.setHobby(instructor.getInstructorDetail().getHobby());
        instructorDetailsDto.setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());

        instructorDto.setInstructorDetails(instructorDetailsDto);

        return instructorDto;
    }

    @Override
    public String deleteInstructor(long instructorId) {
        /*Optional<InstructorDto> instructorOptional = instructorRepository.findById((int) instructorId);
        InstructorDto instructor = instructorOptional.get();*/
        instructorRepository.deleteById(instructorId);
        return "InstructorDto is deleted successfully! instructorId is : " + instructorId;
    }

    @Override
    public InstructorDetailResponse getInstructorDetail(long instructorDetailId) {
        InstructorDetailResponse response = new InstructorDetailResponse();

        Optional<InstructorDetail> instructorDetailOptional = instructorDetailRepository.findById(instructorDetailId);
        InstructorDetail instructorDetail = instructorDetailOptional.get();

        response.setHobby(instructorDetail.getHobby());
        response.setYoutubeChannel(instructorDetail.getYoutubeChannel());

        InstructorResponse instructorResponse = new InstructorResponse();
        instructorResponse.setFirstName(instructorDetail.getInstructor().getFirstName());
        instructorResponse.setLastName(instructorDetail.getInstructor().getLastName());
        instructorResponse.setEmail(instructorDetail.getInstructor().getEmail());

        response.setInstructorResponse(instructorResponse);

        return response;
    }

    @Override
    @Transactional
    public String deleteInstructorDetail(long instructorDetailId) {

/*        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, instructorDetailId);
        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);*/

       // jpa is not working
/*        Optional<InstructorDetail> instructorDetailOptional = instructorDetailRepository.findById(instructorDetailId);
        InstructorDetail instructorDetail = instructorDetailOptional.get();
        instructorDetailRepository.delete(instructorDetail);*/

        //its working
        instructorDetailRepository.deleteById(instructorDetailId);

        return "InstructorDetail is deleted successfully! instructorDetailId is : " + instructorDetailId;
    }

   /* @Transactional
    @Override
    public Instructor saveInstructorAndCourse(Instructor instructor) {

        Instructor instructorEntity = new Instructor();
        instructorEntity.setFirstName(instructor.getFirstName());
        instructorEntity.setLastName(instructor.getLastName());
        instructorEntity.setEmail(instructor.getEmail());

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructor.getInstructorDetail().getHobby());
        instructorDetail.setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());
        instructorEntity.setInstructorDetail(instructorDetail);


        List<Course> courses = new ArrayList<>();
        instructor.getCourses().forEach(course -> {
            course.setTitle(course.getTitle());
            courses.add(course);
        });

        instructorEntity.setCourses(courses);

        Instructor savedInstructorCourses = instructorRepository.save(instructorEntity);
        return savedInstructorCourses;
    }*/

}

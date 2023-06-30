package com.restcurd.repository;

import com.restcurd.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Long> {
}

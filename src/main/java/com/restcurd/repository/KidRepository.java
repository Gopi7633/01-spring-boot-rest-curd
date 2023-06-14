package com.restcurd.repository;

import com.restcurd.entity.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository

//@RepositoryRestResource(path = "members")
public interface KidRepository extends JpaRepository<Kid,Long> {
}

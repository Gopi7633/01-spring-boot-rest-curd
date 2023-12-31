package com.restcurd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {
    private String firstName;
    private String lastName;
    private String email;

    private InstructorDetailsDto instructorDetails;
}

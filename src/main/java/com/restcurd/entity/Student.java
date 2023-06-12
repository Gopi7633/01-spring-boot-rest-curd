package com.restcurd.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String firstName;
    private String lastName;
    private long age;
}

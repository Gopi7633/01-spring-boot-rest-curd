package com.restcurd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

//    @Column(name="instructor_detail_id")
//    private long instructorDetailId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

/*    @OneToOne(cascade = {
            CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.REFRESH },fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;*/

//    @OneToMany(mappedBy = "instructor",
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Course> courses;
}









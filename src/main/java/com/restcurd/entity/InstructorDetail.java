package com.restcurd.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

//    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Instructor instructor;

    @OneToOne(mappedBy = "instructorDetail",cascade = {
            CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Instructor instructor;
}











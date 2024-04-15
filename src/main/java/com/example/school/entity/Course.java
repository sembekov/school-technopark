package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseId")
    private Integer id;
    @Column(name = "courseName")
    private String courseName;

}

package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollmentId")
    private Long enrollmentId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    @Column(name = "enrollmentDate")
    private Date enrollmentDate;
}

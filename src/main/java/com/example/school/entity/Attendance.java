package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendanceId")
    private Long attendanceId;
    @Column(name = "attendanceCount")
    private Integer attendanceCount;

    @ManyToOne
    private Course course;

    private Date date;
}


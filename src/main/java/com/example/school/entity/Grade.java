package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="grades")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gradeId")
    private Integer id;
    @Column(name = "grade")
    private String grade;
    //@ManyToOne
    //private Student student;
}

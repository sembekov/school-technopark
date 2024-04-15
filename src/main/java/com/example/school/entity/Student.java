package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;

    @ManyToOne
    private Grade grade;

    @ManyToOne
    private School school;

    @ManyToOne
    private Course course;

}

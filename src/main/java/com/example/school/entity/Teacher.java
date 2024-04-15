package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacherId")
    private Integer teacherId;
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
    private School school;
}

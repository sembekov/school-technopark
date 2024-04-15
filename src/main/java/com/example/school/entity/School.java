package com.example.school.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "school")
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schoolId")
    private Integer schoolId;
    @Column(name = "schoolName")
    private String schoolName;
    @Column
    private String location;
}

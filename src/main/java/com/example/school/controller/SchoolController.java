package com.example.school.controller;

import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public Optional<School> getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @PutMapping("/update/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School schoolDetails) {
        return schoolService.updateSchool(id, schoolDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllSchools() {
        schoolService.deleteAllSchools();
    }
}

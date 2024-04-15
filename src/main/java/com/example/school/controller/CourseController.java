package com.example.school.controller;

import com.example.school.entity.Course;
import com.example.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}

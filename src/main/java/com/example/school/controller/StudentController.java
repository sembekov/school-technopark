package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }
}

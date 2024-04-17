package com.example.school.controller;

import com.example.school.entity.Enrollment;
import com.example.school.entity.Grade;
import com.example.school.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grades")
public class GradesController {
    private GradeService gradeService;

    @GetMapping("/grade-{id}")
    public Optional<Grade> getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @GetMapping()
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }


    // Uncomment this method if needed
    /*
    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }
    */

    // Uncomment this method if needed
    /*
    @PostMapping("/add")
    public void addGrade(@RequestBody Grade grade) {
        // Implementation
    }
    */

    @PutMapping("/update/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        return gradeService.updateGrade(id, gradeDetails);
    }

    @DeleteMapping("/delete/all")
    public String deleteAllGrades() {
        gradeService.deleteAllGrades();
        return "All grades have been deleted!";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }
}

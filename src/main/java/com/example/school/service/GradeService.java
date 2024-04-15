package com.example.school.service;

import com.example.school.entity.Grade;
import com.example.school.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }
    public Grade updateGrade(Long id, Grade gradeDetails) {
        Optional<Grade> grade = gradeRepository.findById(id);

        if (grade.isPresent()){
            Grade existingGrade = grade.get();
            existingGrade.setGrade(gradeDetails.getGrade());
            return gradeRepository.save(existingGrade);
        }
        return null;
    }

    public void deleteAllGrades() {
        gradeRepository.deleteAll();
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}

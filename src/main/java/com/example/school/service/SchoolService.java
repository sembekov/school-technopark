package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    public School updateSchool(Long id, School schoolDetails) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            School existingSchool = school.get();
            existingSchool.setSchoolName(schoolDetails.getSchoolName());
            //existingSchool.setLocation(schoolDetails.getLocation());
            return schoolRepository.save(existingSchool);
        } else {
            return null; // Handle error, school not found
        }
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public void deleteAllSchools() {
        schoolRepository.deleteAll();
    }
}

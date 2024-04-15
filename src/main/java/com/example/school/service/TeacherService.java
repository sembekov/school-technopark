package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.entity.Teacher;
import com.example.school.repository.SchoolRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        // Update the teacher details
        teacher.setFirstName(teacherDetails.getFirstName());
        teacher.setLastName(teacherDetails.getLastName());
        teacher.setBirthday(teacherDetails.getBirthday());
        teacher.setGender(teacherDetails.getGender());
        teacher.setMobile(teacherDetails.getMobile());
        teacher.setEmail(teacherDetails.getEmail());
        teacher.setSchool(schoolRepository.getReferenceById(id));
        //teacher.setSchoolId(teacherDetails.getSchoolId());

        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }
}

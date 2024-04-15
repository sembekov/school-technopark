package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.GradeRepository;
import com.example.school.repository.SchoolRepository;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent(Student student) {
        if (student.getGrade() != null && student.getGrade().getId() == null) {
            student.setGrade(gradeRepository.save(student.getGrade()));
        }

        if (student.getSchool() != null && student.getSchool().getSchoolId() == null) {
            student.setSchool(schoolRepository.save(student.getSchool()));
        }

        if (student.getCourse() != null && student.getCourse().getId() == null) {
            student.setCourse(courseRepository.save(student.getCourse()));
        }

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setGrade(gradeRepository.getReferenceById(id));
        student.setBirthday(studentDetails.getBirthday());
        student.setGender(studentDetails.getGender());
        student.setMobile(studentDetails.getMobile());
        student.setEmail(studentDetails.getEmail());
        student.setSchool(schoolRepository.getReferenceById(id));

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}

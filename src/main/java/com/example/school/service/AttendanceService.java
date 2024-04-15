package com.example.school.service;

import com.example.school.entity.Attendance;
import com.example.school.repository.AttendanceRepository;
import com.example.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        attendance.setAttendanceCount(attendanceDetails.getAttendanceCount());
        attendance.setCourse(courseRepository.getById(id));
        attendance.setDate(attendanceDetails.getDate());

        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public void deleteAllAttendances() {
        attendanceRepository.deleteAll();
    }
}

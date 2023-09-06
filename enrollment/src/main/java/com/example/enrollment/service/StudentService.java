package com.example.enrollment.service;

import com.example.enrollment.model.Course;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.Student;
import com.example.enrollment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepo studentRepo;


    public Student findStudentById(Integer id){ return studentRepo.findStudentById(id);}
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Course> getCoursesForStudent(Student student) {
        List<Course> enrolledCourses = new ArrayList<>();
        for (Enrollment enrollment : student.getEnrollments()) {
            enrolledCourses.add(enrollment.getCourse());
        }
        return enrolledCourses;
    }
}

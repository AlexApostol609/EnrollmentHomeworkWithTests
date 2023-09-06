package com.example.enrollment.controller;

import com.example.enrollment.model.Course;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.Student;
import com.example.enrollment.repository.StudentRepo;
import com.example.enrollment.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudent" )
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);

    }

    @GetMapping(value = "/students/{studentId}")
    public List<Course> getCoursesForStudent(@PathVariable Integer studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            return studentService.getCoursesForStudent(student);
        } else {
            // Handle the case where the student with the provided ID is not found
            throw new EntityNotFoundException("Student not found");
        }
    }
}

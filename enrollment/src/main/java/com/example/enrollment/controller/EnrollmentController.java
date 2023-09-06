package com.example.enrollment.controller;

import com.example.enrollment.model.Course;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.Student;
import com.example.enrollment.service.CourseService;
import com.example.enrollment.service.EnrollmentService;
import com.example.enrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {


    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/enrolls")
    public Enrollment enrollStudentOnCourse(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudentsOnCourses(enrollment);
    }

}

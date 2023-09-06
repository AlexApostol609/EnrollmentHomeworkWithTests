package com.example.enrollment.service;

import com.example.enrollment.model.Enrollment;
import com.example.enrollment.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepo enrollmentRepo;

    public Enrollment enrollStudentsOnCourses(Enrollment enrollment){
        return enrollmentRepo.save(enrollment);
    }
}

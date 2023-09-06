package com.example.enrollment.service;

import com.example.enrollment.model.Course;
import com.example.enrollment.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;


    public Course findCourseById(Integer id){ return courseRepo.findCourseById(id);}
    public Course saveCourse(Course c){
        return courseRepo.save(c);
    }
}

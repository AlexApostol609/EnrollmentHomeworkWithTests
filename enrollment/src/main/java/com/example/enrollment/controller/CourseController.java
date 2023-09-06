package com.example.enrollment.controller;

import com.example.enrollment.model.Course;
import com.example.enrollment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(value = "/createCourse" )
    public Course createCourse(@RequestBody Course course){
        return courseService.saveCourse(course);

    }
}

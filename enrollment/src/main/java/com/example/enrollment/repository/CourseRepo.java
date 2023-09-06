package com.example.enrollment.repository;

import com.example.enrollment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

    public Course findCourseById(Integer id);
}

package com.example.enrollment.repository;

import com.example.enrollment.model.Course;
import com.example.enrollment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    public Student findStudentById(Integer id);
}

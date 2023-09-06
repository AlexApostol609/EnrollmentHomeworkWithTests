package com.example.enrollment.repository;

import com.example.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer>{
}

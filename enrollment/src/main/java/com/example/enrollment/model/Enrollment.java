package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue
    Integer id;

    Date enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonManagedReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    private Course course;



    public void setCourse(Course course) {
        this.course = course;
        course.getEnrollments().add(this);
         // Synchronize the bidirectional relationship
    }

    public void setStudent(Student student) {
        this.student = student;
        student.getEnrollments().add(this);
        // Synchronize the bidirectional relationship
    }


}

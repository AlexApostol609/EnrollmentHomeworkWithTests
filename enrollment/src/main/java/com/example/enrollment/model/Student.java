package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    String email;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Enrollment> enrollments = new ArrayList<>();

}

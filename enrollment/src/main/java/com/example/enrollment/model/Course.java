package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    Integer id;

    String title;
    String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Enrollment> enrollments = new ArrayList<>();


}

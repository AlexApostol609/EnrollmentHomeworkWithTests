package com.example.enrollment.tests;

import com.example.enrollment.controller.StudentController;
import com.example.enrollment.model.Course;
import com.example.enrollment.model.Student;
import com.example.enrollment.repository.StudentRepo;
import com.example.enrollment.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class StudentControllerTestClass {

    @MockBean
    private StudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    public void testStudentsWithoutCourses() {
        Integer studentId = 1;

        Student studentWithoutCourses = new Student();
        studentWithoutCourses.setId(studentId);
        studentWithoutCourses.setName("John");
        studentWithoutCourses.setEmail("john@example.com");

        Mockito.when(service.findStudentById(studentId)).thenReturn(studentWithoutCourses);

        Iterable<Course> courses = controller.getCoursesForStudent(studentId);

        assertEquals(Collections.emptyList(), courses);
    }

}

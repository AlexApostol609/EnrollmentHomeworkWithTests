package com.example.enrollment.tests;

import com.example.enrollment.controller.EnrollmentController;
import com.example.enrollment.controller.StudentController;
import com.example.enrollment.model.Course;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.Student;
import com.example.enrollment.service.EnrollmentService;
import com.example.enrollment.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class EnrollmentControllerTestClass {

    @MockBean
    private EnrollmentService enrollmentService;


    @MockBean
    private StudentService studentService;
    @InjectMocks
    private EnrollmentController enrollmentController;

    @Test
    public void checkIfStudentsEnrollInClasses(){

            Student student = new Student();
            student.setId(1);
            student.setName("John");

            Course course = new Course();
            course.setId(1);
            course.setTitle("Math");

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setEnrollmentDate(new Date());

            Mockito.when(enrollmentService.enrollStudentsOnCourses(enrollment)).thenReturn(enrollment);
            Mockito.when(studentService.getCoursesForStudent(student)).thenReturn(Collections.singletonList(course));

            enrollmentController.enrollStudentOnCourse(enrollment);

            List<Course> studentCourses = studentService.getCoursesForStudent(student);

            assertEquals(1, studentCourses.size());
            assertEquals(course, studentCourses.get(0));

        }
}

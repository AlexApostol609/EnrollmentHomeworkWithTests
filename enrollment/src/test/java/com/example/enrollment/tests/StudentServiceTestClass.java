package com.example.enrollment.tests;

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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class StudentServiceTestClass {

    @MockBean
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testStudentsWithoutExistingId(){

        Integer studentId = null;

        Mockito.when(studentRepo.findStudentById(studentId)).thenReturn(null);

        Student result= studentService.findStudentById(studentId);

        assertNull(result);

    }
}

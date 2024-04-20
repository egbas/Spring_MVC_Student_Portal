package com.example.studen_portal_MVC.service;

import com.example.studen_portal_MVC.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student updatedStudent(Student student);


    void deleteStudentById(Long id);

    Student getStudentsById(Long id);
}

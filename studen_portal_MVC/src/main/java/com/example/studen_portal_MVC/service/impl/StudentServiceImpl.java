package com.example.studen_portal_MVC.service.impl;

import com.example.studen_portal_MVC.entity.Student;
import com.example.studen_portal_MVC.repository.StudentRepository;
import com.example.studen_portal_MVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updatedStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student getStudentsById(Long id) {
        return studentRepository.findById(id).get();
    }


}

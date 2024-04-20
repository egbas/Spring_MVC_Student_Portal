package com.example.studen_portal_MVC.repository;

import com.example.studen_portal_MVC.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}

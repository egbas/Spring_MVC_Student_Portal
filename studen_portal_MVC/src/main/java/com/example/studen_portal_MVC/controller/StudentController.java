package com.example.studen_portal_MVC.controller;

import com.example.studen_portal_MVC.entity.Student;
import com.example.studen_portal_MVC.service.StudentService;
import org.hibernate.annotations.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //Handler method to handle student list and return model and view

    @GetMapping("/students")
    public String listAllStudents(Model model){
         model.addAttribute("students", studentService.getAllStudents());
         return "students";
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model){
        Student student= new Student();
        model.addAttribute("student", student);

        return"create_student";

    }


    @PostMapping("/students")
    public String saveStudent(@ModelAttribute ("student") Student student){
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentsById(id));

        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){

        Student existingStudent = studentService.getStudentsById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updatedStudent(existingStudent);

        return "redirect:/students";

    }

    @GetMapping("/students/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);

        return "redirect:/students";
    }
}

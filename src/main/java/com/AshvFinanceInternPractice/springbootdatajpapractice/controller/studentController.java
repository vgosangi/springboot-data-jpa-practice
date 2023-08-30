package com.AshvFinanceInternPractice.springbootdatajpapractice.controller;


import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.Student;
import com.AshvFinanceInternPractice.springbootdatajpapractice.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class studentController {


    @Autowired
    private StudentService studentService;


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping( value = "/students/{id}")
    public Object getStudentbyId(@PathVariable("id") Long studentId){
        return studentService.getStudentbyId(studentId);
    }

    @DeleteMapping( value = "/students/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Student deleted Successfully";

    }

    @PutMapping(value = "/students/{id}")
    public Object saveStudentByID(@PathVariable("id") Long studentId, @RequestBody Student student){

        return studentService.saveStudentByID(studentId,student);
    }
    //from branch1 to check conflicts

}

package com.AshvFinanceInternPractice.springbootdatajpapractice.service;

import com.AshvFinanceInternPractice.springbootdatajpapractice.VO.Department;
import com.AshvFinanceInternPractice.springbootdatajpapractice.VO.ResponseVO;
import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.Student;
import com.AshvFinanceInternPractice.springbootdatajpapractice.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class StudentService {
    private final String DepUrl ="http://localhost:8081/departments";

     RestTemplate restTemplate =new RestTemplate();

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return (Student) studentRepository.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Object getStudentbyId(Long studentId) {
        try {
            Optional<Student> student = studentRepository.findById(studentId);

            Long depId = student.get().getDepartmentId();
            Map<String, Object> map = new HashMap<>();
            map.put("student", student);
//        System.out.println(depId);
            try {
                Object department = restTemplate.getForObject(DepUrl + "/" + depId, Object.class);

                map.put("department", department);
                return map;
            } catch (Exception e) {
                Object department = "department not found";
                map.put("department", department);
                return map;
            }
        }catch (Exception e){
            return "Invalid student Id";
        }
       // System.out.println(department);



    }


    public Object saveStudentByID(Long studentId, Student student) {
        Student studentDb = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())){
            studentDb.setFirstName(student.getFirstName());
        }
        if(Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())){
            studentDb.setLastName(student.getLastName());
        }
        if(Objects.nonNull(student.getDepartmentId()) && !"".equalsIgnoreCase(String.valueOf(student.getDepartmentId()))){
            studentDb.setDepartmentId(student.getDepartmentId());
        }


        return studentRepository.save(studentDb);
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

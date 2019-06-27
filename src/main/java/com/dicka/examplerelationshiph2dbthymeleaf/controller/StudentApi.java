package com.dicka.examplerelationshiph2dbthymeleaf.controller;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentApi {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> listStudent(){
        List<Student> students = new ArrayList<>();
        List<Student> studentRepos = studentRepository.findAll();

        for (Student student : studentRepos)
            students.add(student);

        return students;
    }
}

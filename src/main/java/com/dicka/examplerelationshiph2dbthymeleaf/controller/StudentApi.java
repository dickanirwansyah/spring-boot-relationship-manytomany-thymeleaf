package com.dicka.examplerelationshiph2dbthymeleaf.controller;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Course;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import com.dicka.examplerelationshiph2dbthymeleaf.model.RequestStudentCourse;
import com.dicka.examplerelationshiph2dbthymeleaf.model.ResponseData;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.CourseRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentApi {

    private static final Logger log = LoggerFactory.getLogger(StudentApi.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Student> listStudent(){
        List<Student> students = new ArrayList<>();
        List<Student> studentRepos = studentRepository.findAll();

        for (Student student : studentRepos)
            students.add(student);

        return students;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Student> createStudentAndCourse(@RequestBody RequestStudentCourse studentCourse){

        Student entityStudent = null;
        try{

            Course course;
            List<Course> courseList = new ArrayList<>();
            for (int i=0; i < studentCourse.getCourses().length; i++){
                course = new Course();
                course.setCourserName(studentCourse.getCourses()[i]);
                courseList.add(course);
                courseRepository.save(course);
            }

            entityStudent = new Student();
            entityStudent.setFirstname(studentCourse.getFirstname());
            entityStudent.setLastname(studentCourse.getLastname());
            entityStudent.setEmail(studentCourse.getEmail());
            entityStudent.getCourses().addAll(courseList);
            studentRepository.save(entityStudent);

            log.info("createStudentAndCourse : "+entityStudent.toString());


        }catch (NullPointerException e){
            log.info("createStudentAndCourse : "+e.toString());
            e.printStackTrace();
        }

        return new ResponseEntity<Student>(entityStudent, HttpStatus.CREATED);
    }
}

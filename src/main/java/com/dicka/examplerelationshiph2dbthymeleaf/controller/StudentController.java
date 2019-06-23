package com.dicka.examplerelationshiph2dbthymeleaf.controller;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Course;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.CourseRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudent(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("title", "Data Siswa");
        model.addAttribute("students", students);
        log.info("getStudent()");
        return "index";
    }

    @RequestMapping(value = "/addStudent")
    public String getAddStudent(Model model){
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new Student());
        log.info("getAddStudent()");
        return "add_student";
    }

    @RequestMapping(value = "/save")
    public String saveStudent(Student student){
        studentRepository.save(student);
        log.info("saveStudent()");
        return "redirect:/student";
    }

    @RequestMapping(value = "/get/{studentId}")
    public String getStudentId(@PathVariable("studentId") Long studentId,
                               Model model){

        Student findStudentId = studentRepository.findByStudentId(studentId);

        model.addAttribute("title", "Data Student");
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("student", findStudentId);

        log.info("getStudentId() : "+studentId);
        return "add_student_course";
    }

    @RequestMapping(value = "/addCourseStudent/{studentId}/course")
    public String addCourseStudent(@PathVariable("studentId") Long studentId,
                                   @RequestParam("courseId") Long courseId){

        Course course = courseRepository.findByCourseId(courseId);
        Student student = studentRepository.findByStudentId(studentId);

        if (student!=null){
            student.getCourses().add(course);
            log.debug("TEST STUDENT-COURSE == "+student.getCourses().add(course));
            studentRepository.save(student);
        }
        return "redirect:/student";
    }

}

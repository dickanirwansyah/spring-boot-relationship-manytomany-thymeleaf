package com.dicka.examplerelationshiph2dbthymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course implements Serializable{

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name")
    private String courserName;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public Course(){}

    public Course(String courserName){
        this.courserName = courserName;
    }

    public Long getCourseId(){
        return courseId;
    }

    public void setCourseId(Long courseId){
        this.courseId = courseId;
    }

    public String getCourserName(){
        return courserName;
    }

    public void setCourserName(String courserName){
        this.courserName = courserName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

package com.dicka.examplerelationshiph2dbthymeleaf.repository;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(Long studentId);

    @Query("SELECT s FROM Student s WHERE s.firstname = :firstname")
    List<Student> cariStudentBerdasarkanFirstname(@Param(value = "firstname")String firstname);
}

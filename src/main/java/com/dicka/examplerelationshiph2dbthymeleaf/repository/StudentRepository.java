package com.dicka.examplerelationshiph2dbthymeleaf.repository;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(Long studentId);
}

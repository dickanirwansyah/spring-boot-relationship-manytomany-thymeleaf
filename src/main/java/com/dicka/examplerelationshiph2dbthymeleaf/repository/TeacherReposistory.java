package com.dicka.examplerelationshiph2dbthymeleaf.repository;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherReposistory extends JpaRepository<Teacher, Long>{
}

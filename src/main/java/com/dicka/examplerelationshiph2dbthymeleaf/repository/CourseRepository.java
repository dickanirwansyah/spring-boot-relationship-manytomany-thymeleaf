package com.dicka.examplerelationshiph2dbthymeleaf.repository;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseId(Long courseId);

}

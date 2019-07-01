package com.dicka.examplerelationshiph2dbthymeleaf;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Course;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.CourseRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExampleRelationshipH2dbThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRelationshipH2dbThymeleafApplication.class, args);
	}

}

@Component
class CommandLineRunnerData implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		try{

			List<Student> students = new ArrayList<>();
			students = studentRepository.cariStudentBerdasarkanFirstname("dicka");

			if (students.size() > 0){
				System.out.println("found : "+students.size());
			}else{
				System.out.println("notfound.");
			}

		}catch (NullPointerException e){
			e.printStackTrace();
		}

	}

//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Autowired
//	private CourseRepository courseRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		//INSERT MANY TO MANY
//		String[] data = {"go", "php", "java"};
//		List<Course> courses = new ArrayList<>();
//
//		Course course;
//		for (int i=0; i < data.length; i++){
//			course = new Course();
//			course.setCourserName(data[i]);
//			courses.add(course);
//			courseRepository.save(course);
//		}
//
//		Student student = new Student();
//		student.setFirstname("mumu");
//		student.setLastname("gomez");
//		student.setEmail("mumugomez@gmail.com");
//		student.getCourses().addAll(courses);
//		studentRepository.save(student);
//
//	}
}

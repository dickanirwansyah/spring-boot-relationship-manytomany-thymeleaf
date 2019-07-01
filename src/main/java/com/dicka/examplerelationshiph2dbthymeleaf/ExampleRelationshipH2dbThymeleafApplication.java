package com.dicka.examplerelationshiph2dbthymeleaf;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Address;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Course;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Student;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Teacher;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.AddressRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.CourseRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.StudentRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.TeacherReposistory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

	@Autowired
	private TeacherReposistory teacherReposistory;

	@Autowired
	private AddressRepository addressRepository;

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

		try{

			Address address = new Address();
			Teacher teacher = new Teacher();

			address.setNo("address no 1");
			address.setProvince("address province 1");
			address.setZipcode("12430");
			address.setStreet("address street 1");
			address.setVillage("address vilage 1");


			teacher.setName("teacher name 1");
			teacher.setDob(new Date());
			teacher.setAddress(address);

			addressRepository.save(address);
			teacherReposistory.save(teacher);


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

package com.dicka.examplerelationshiph2dbthymeleaf.controller;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Address;
import com.dicka.examplerelationshiph2dbthymeleaf.entity.Teacher;
import com.dicka.examplerelationshiph2dbthymeleaf.model.RequestTeacherAddress;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.AddressRepository;
import com.dicka.examplerelationshiph2dbthymeleaf.repository.TeacherReposistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherApi {

    private static Logger log = LoggerFactory.getLogger(TeacherApi.class);

    @Autowired
    private TeacherReposistory teacherReposistory;

    @Autowired
    private AddressRepository addressRepository;

    private Map<String, String> hashMapValidation;

    @GetMapping
    public List<Teacher> listTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        List<Teacher> teachersResult = teacherReposistory.findAll();

        for (Teacher teacher : teachersResult){
            teachers.add(teacher);
        }

        return teachers;
    }

    @PostMapping
    public ResponseEntity<Object> saveTeacher(@RequestBody @Valid RequestTeacherAddress req,
                                              BindingResult bindingResult){

        Teacher teacher = null;
        Address address = null;

        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Object>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        try{

            teacher = new Teacher();
            address = new Address();

            teacher.setName(req.getName());
            teacher.setDob(req.getDob());

            address.setStreet(req.getStreet());
            address.setZipcode(req.getZipcode());
            address.setProvince(req.getProvince());
            address.setNo(req.getNo());
            address.setVillage(req.getVillage());
            teacher.setAddress(address);

            addressRepository.save(address);
            teacherReposistory.save(teacher);

        }catch (NullPointerException e){
               e.printStackTrace();
        }

        return new ResponseEntity<Object>(teacher, HttpStatus.CREATED);
    }
}

package com.dicka.examplerelationshiph2dbthymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String no;
    private String village;
    private String province;
    private String zipcode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    public Address(){}

    public Address(String street, String no, String village, String province, String zipcode) {
        this.street = street;
        this.no = no;
        this.village = village;
        this.province = province;
        this.zipcode = zipcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", no='" + no + '\'' +
                ", village='" + village + '\'' +
                ", province='" + province + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}

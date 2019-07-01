package com.dicka.examplerelationshiph2dbthymeleaf.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class RequestTeacherAddress implements Serializable {

    @NotBlank(message = "name is not null")
    private String name;

    @NotNull(message = "dob is not null")
    private Date dob;

    @NotBlank(message = "street is not null")
    private String street;

    @NotBlank(message = "no is not null")
    private String no;

    @NotBlank(message = "village is not null")
    private String village;

    @NotBlank(message = "province is not null")
    private String province;

    @NotBlank(message = "zipcode is not null")
    private String zipcode;

    public RequestTeacherAddress(){}

    public RequestTeacherAddress(@NotBlank(message = "name is not null") String name, @NotNull(message = "dob is not null") Date dob, @NotBlank(message = "street is not null") String street, @NotBlank(message = "no is not null") String no, @NotBlank(message = "village is not null") String village, @NotBlank(message = "province is not null") String province, @NotBlank(message = "zipcode is not null") String zipcode) {
        this.name = name;
        this.dob = dob;
        this.street = street;
        this.no = no;
        this.village = village;
        this.province = province;
        this.zipcode = zipcode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
}

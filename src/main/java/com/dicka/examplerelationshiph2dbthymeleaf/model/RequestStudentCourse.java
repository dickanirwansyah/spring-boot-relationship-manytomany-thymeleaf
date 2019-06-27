package com.dicka.examplerelationshiph2dbthymeleaf.model;

public class RequestStudentCourse {

    private String firstname;
    private String lastname;
    private String email;
    private String[] courses;

    public RequestStudentCourse(){}

    public RequestStudentCourse(String firstname, String lastname, String email, String[] courses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.courses = courses;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
}

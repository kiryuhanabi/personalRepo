package com.example.table;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String secondName;
    private String country;
    private String id;
    private String age;
    private LocalDate dateOfBirth;
    private String major;
    private String status;

    public Person(String firstName, String secondName, String country, String id, String age, LocalDate dateOfBirth, String major, String status) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.id = id;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

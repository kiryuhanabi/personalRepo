package com.example.table;

public class Person {

    private String firstName;
    private String secondName;
    private String country;

    public Person(String firstName, String secondName, String country) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getCountry() {
        return country;
    }
}


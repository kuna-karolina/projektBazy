package com.example.bazyprojekt.model.mongo;

import org.springframework.data.annotation.Id;

public class Address {


}



    @Id
    private long Id;
    private String streetName;
    private String city;
    private String buildingNr;
    private String postalCode;
    private String apartmentNr;



    public Address(int id, String streetName, String city, String buildingNr, String postalCode, String apartmentNr) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
        this.buildingNr = buildingNr;
        this.postalCode = postalCode;
        this.apartmentNr = apartmentNr;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


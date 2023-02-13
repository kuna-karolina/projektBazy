package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name="Address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="street_name")
    private String streetName;
    @Column(name="city")
    private String city;
    @Column(name = "building_number")
    private int buildingNr;
    @Column(name="postal_code")
    private int postalCode;
    @Column(name="apartment_number")
    private int apartmentNr;

    @OneToOne(mappedBy = "address")
    private Owner owner;

    @OneToOne(mappedBy = "address")
    private Apartment apartment;

}

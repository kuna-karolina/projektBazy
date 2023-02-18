package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private String buildingNr;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="apartment_number")
    private String apartmentNr;

    @OneToOne(mappedBy = "address")
    private Owner owner;

    @OneToOne(mappedBy = "address")
    private Apartment apartment;

    public Address(int id, String streetName, String city, String buildingNr, String postalCode, String apartmentNr) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
        this.buildingNr = buildingNr;
        this.postalCode = postalCode;
        this.apartmentNr = apartmentNr;
    }
}

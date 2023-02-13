package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "apartment")
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "area")
    private double area;
    @Column(name = "creation_year")
    private int creationYear;
    @Column(name = "lastRenovationYear")
    private int lastRenovationYear;
    @Column(name = "building_type")
    private String buildingType;
    @Column(name = "is_furnished")
    private boolean isFurnished;
    @Column(name = "rooms_count")
    private int roomsCount;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "apartment")
    private Set<Offer> offers;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

}

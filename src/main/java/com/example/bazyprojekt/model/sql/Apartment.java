package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@ToString
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
    private String creationYear;
    @Column(name = "lastRenovationYear")
    private String lastRenovationYear;
    @Column(name = "building_type")
    private String buildingType;
    @Column(name = "is_furnished")
    private boolean isFurnished;

    @Column(name = "rooms_count")
    private String roomsCount;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "apartment")
    private Set<Offer> offers;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public Apartment(long id, double area, String creationYear, String lastRenovationYear, String buildingType, boolean isFurnished, String roomsCount) {
        this.id = id;
        this.area = area;
        this.creationYear = creationYear;
        this.lastRenovationYear = lastRenovationYear;
        this.buildingType = buildingType;
        this.isFurnished = isFurnished;
        this.roomsCount = roomsCount;
    }


}

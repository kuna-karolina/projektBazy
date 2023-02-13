package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name="offer")
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="company_name")
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "offer_apartment_id")
    private Apartment apartment;

}

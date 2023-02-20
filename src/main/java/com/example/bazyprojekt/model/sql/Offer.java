package com.example.bazyprojekt.model.sql;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Table(name="offer")
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="creation_date")
    private Date creationDate;
    @Column(name="negotiable")
    private boolean negotiable;
    @Column(name="description")
    private String description;
    @Column(name="agency_fee")
    private Double agencyFee;
    @Column(name="title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "offer_apartment_id")
    private Apartment apartment;

    public Offer(long id, Date creationDate, boolean negotiable, String description, Double agencyFee, String title) {
        this.id = id;
        this.creationDate = creationDate;
        this.negotiable = negotiable;
        this.description = description;
        this.agencyFee = agencyFee;
        this.title = title;
    }
}

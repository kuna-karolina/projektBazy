package com.example.bazyprojekt.model.sql;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name="owner")
@Entity
public class Owner {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private Date creationDate;
    @Column
    private double price;
    @Column
    private String status;
    @Column
    private boolean negotiable;
    @Column
    private Date modificationDate;
    @Column
    private String descritpion;
    @Column
    private double agencyFee;
    @Column
    private String title;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Apartment> apartments;

}

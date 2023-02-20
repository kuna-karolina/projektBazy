package com.example.bazyprojekt.model.sql;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="owner")
@Entity
public class Owner {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phoneNumber;
    @Column
    private String emailAddress;

    public Owner(long id, String name, String surname, String phoneNumber, String emailAddress, String companyName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
    }
    @Column
    private String companyName;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Apartment> apartments;

}

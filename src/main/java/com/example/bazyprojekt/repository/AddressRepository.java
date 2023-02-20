package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository {
    List<Address> findAll();

    Address findById(long id);

    void deleteById(long id);

    void delete(Address address);

    Address save(Address address);

    long count();
}

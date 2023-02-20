package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Apartment;

import java.util.List;

public interface ApartmentRepository {

    List<Apartment> findAll();

    Apartment findById(long id);

    void deleteById(long id);

    void delete(Apartment apartment);

    Apartment save(Apartment apartment);

    long count();

}

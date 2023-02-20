package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Owner;

import java.util.List;

public interface OwnerRepository {

    List<Owner> findAll();

    Owner findById(long id);

    void deleteById(long id);

    void delete(Owner owner);

    Owner save(Owner owner);

    long count();

}

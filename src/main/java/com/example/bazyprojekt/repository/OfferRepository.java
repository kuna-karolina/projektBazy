package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Offer;

import java.util.List;

public interface OfferRepository {

    List<Offer> findAll();

    Offer findById(long id);

    void deleteById(long id);

    void delete(Offer offer);

    Offer save(Offer offer);

    long count();

}

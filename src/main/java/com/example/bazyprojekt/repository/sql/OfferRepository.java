package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer,Long> {
}

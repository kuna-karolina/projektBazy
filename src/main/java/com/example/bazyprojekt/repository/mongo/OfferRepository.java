package com.example.bazyprojekt.repository.mongoDB;

import com.example.bazyprojekt.model.mongo.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Long> {
}


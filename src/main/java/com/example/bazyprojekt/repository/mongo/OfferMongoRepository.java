package com.example.bazyprojekt.repository.mongo;

import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.repository.OfferRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("database-mongo")
public interface OfferMongoRepository extends OfferRepository, MongoRepository<Offer, String> {
}

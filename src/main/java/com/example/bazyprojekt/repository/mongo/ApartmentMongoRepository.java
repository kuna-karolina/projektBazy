package com.example.bazyprojekt.repository.mongo;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.repository.ApartmentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("database-mongo")
interface ApartmentMongoRepository extends ApartmentRepository, MongoRepository<Apartment, String> {
}

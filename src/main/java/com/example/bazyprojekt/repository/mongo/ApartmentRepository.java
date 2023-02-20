package com.example.bazyprojekt.repository.mongoDB;

import com.example.bazyprojekt.model.mongo.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository <Apartment, Long> {
}

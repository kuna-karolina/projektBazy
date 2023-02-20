package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment,Long> {
}

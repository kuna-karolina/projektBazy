package com.example.bazyprojekt.repository.sql;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.repository.ApartmentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("database-sql")
public interface ApartmentSqlRepository extends ApartmentRepository, CrudRepository<Apartment,Long> {
}

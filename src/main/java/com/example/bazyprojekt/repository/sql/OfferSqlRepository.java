package com.example.bazyprojekt.repository.sql;

import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.repository.OfferRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("database-sql")
public interface OfferSqlRepository extends OfferRepository, CrudRepository<Offer,Long> {
}

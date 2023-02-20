package com.example.bazyprojekt.repository.mongo;

import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.repository.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("database-mongo")
public interface OwnerMongoRepository extends OwnerRepository, MongoRepository<Owner, String> {
}

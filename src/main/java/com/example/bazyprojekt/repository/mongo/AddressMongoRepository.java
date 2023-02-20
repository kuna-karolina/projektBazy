package com.example.bazyprojekt.repository.mongo;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.repository.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("database-mongo")
interface AddressMongoRepository extends AddressRepository, MongoRepository<Address, String> {

}

package com.example.bazyprojekt.repository.mongoDB;

import com.example.bazyprojekt.model.mongo.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository <Address, Long> {
}

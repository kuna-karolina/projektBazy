package com.example.bazyprojekt.repository.mongoDB;

import com.example.bazyprojekt.model.mongo.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository <Owner, Long> {
}

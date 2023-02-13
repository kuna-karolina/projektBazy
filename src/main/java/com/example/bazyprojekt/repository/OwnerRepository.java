package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}

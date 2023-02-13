package com.example.bazyprojekt.repository;

import com.example.bazyprojekt.model.sql.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}

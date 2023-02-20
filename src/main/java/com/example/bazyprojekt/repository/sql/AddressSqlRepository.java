package com.example.bazyprojekt.repository.sql;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.repository.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("database-sql")
interface AddressSqlRepository extends AddressRepository, CrudRepository<Address,Long> {
}

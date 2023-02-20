package com.example.bazyprojekt.repository.sql;

import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.repository.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("database-sql")
public interface OwnerSqlRepository extends OwnerRepository, CrudRepository<Owner,Long> {

}

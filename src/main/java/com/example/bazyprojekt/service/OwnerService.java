package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> findAllOwners(){

        return (List<Owner>) ownerRepository.findAll();

    }

    public Optional<Owner> findOwnersByID(long id){
        return ownerRepository.findById(id);
    }

    public void deleteOwnerByID(long id){
        ownerRepository.deleteById(id);

    }

    public void deleteOwner(Owner owner){
        ownerRepository.delete(owner);

    }
    public Owner saveOwner(Owner owner){
        ownerRepository.save(owner);
        return owner;
    }

    public Owner updateOwner(Owner owner){
        return ownerRepository.save(owner);
    }

}

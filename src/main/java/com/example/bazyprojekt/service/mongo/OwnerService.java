package com.example.bazyprojekt.service.mongo;

import com.example.bazyprojekt.model.mongo.Owner;
import com.example.bazyprojekt.repository.mongoDB.OwnerRepository;
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
}

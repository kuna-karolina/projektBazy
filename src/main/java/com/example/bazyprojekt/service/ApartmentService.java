package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApartmentService {

    @Autowired
    ApartmentRepository apartmentRepository;

    public List<Apartment> findAllApartments(){

        return (List<Apartment>) apartmentRepository.findAll();

    }

    public Optional<Apartment> findApartmentByID(long id){
        return apartmentRepository.findById(id);
    }

    public void deleteApartmentByID(long id){
        apartmentRepository.deleteById(id);

    }

    public void deleteApartment(Apartment apartment){
        apartmentRepository.delete(apartment);

    }

    public Apartment saveApartment(Apartment apartment){
        apartmentRepository.save(apartment);
        return apartment;
    }

    public Apartment updateApartment(Apartment apartment){
        return apartmentRepository.save(apartment);
    }

}

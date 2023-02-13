package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfferService {


    @Autowired
    OfferRepository offerRepository;

    public List<Offer> findAllOffers(){

        return (List<Offer>) offerRepository.findAll();

    }

    public Optional<Offer> findOfferByID(long id){
        return offerRepository.findById(id);
    }

    public void deleteOfferByID(long id){
        offerRepository.deleteById(id);

    }

    public void deleteOffer(Offer offer){
        offerRepository.delete(offer);

    }

    public Offer saveOffer(Offer offer){
        offerRepository.save(offer);
        return offer;
    }

    public Offer updateOffer(Offer offer){
        return offerRepository.save(offer);
    }

}

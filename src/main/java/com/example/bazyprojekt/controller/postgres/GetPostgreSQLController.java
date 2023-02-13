package com.example.bazyprojekt.controller.postgres;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.service.AddressService;
import com.example.bazyprojekt.service.ApartmentService;
import com.example.bazyprojekt.service.OfferService;
import com.example.bazyprojekt.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postgresql/get")
public class GetPostgreSQLController{

    @Autowired
    AddressService addressService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    OfferService offerService;

    @PostMapping("/address")
    public Optional<Address> getAddress(@RequestBody long id) {
        return addressService.findAddressByID(id);
    }

    @PostMapping("/offer")
    public Optional<Offer> getOffer(@RequestBody long id) {
        return offerService.findOfferByID(id);
    }

    @PostMapping("/owner")
    public Optional<Owner> getOwner(@RequestBody long id) {
        return ownerService.findOwnersByID(id);
    }

    @PostMapping("/apartment")
    public Optional<Apartment> getApartment(@RequestBody long id) {
        return apartmentService.findApartmentByID(id);
    }

    @PostMapping("/all/addresses")
    public List<Address> getAllAddresses() {

        return addressService.findAllAddresses();

    }

    @PostMapping("/all/offers")
    public List<Offer> getAllOffers() {
        return offerService.findAllOffers();
    }

    @PostMapping("/all/apartments")
    public List<Apartment> getAllApartments() {
        return apartmentService.findAllApartments();

    }

    @PostMapping("/all/owners")
    public List<Owner> getAllOwners() {
     return ownerService.findAllOwners();
    }
}

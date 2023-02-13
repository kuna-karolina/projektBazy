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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("postgresql/delete")
public class DeletePostgreSQLController {


    @Autowired
    AddressService addressService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    OfferService offerService;


    @PostMapping("/address")
    public void deleteAddress(@RequestBody Address address) {
        addressService.deleteAddress(address);
    }

    @PostMapping("/apartment")
    public void deleteApartment(@RequestBody Apartment apartment) {
        apartmentService.deleteApartment(apartment);
    }

    @PostMapping("/owner")
    public void deleteOwner(@RequestBody Owner owner) {
        ownerService.deleteOwner(owner);
    }

    @PostMapping("/offer")
    public void deleteOffer(@RequestBody Offer offer) {
        offerService.deleteOffer(offer);
    }
}

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

@RestController
@RequestMapping("/postgresql/update")
public class UpdatePostgreSQLController {

    @Autowired
    AddressService addressService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    OfferService offerService;


    @PostMapping("/address")
    public Address updateAddress(@RequestBody Address address){
       return addressService.updateAddress(address);
    }

    @PostMapping("/offer")
    public Offer updateOffer(@RequestBody Offer offer){
        return offerService.updateOffer(offer);
    };

    @PostMapping("/owner")
    public Owner updateOwner(@RequestBody Owner owner){
        return ownerService.updateOwner(owner);
    };

    @PostMapping("/apartment")
    public Apartment updateApartment(@RequestBody Apartment apartment){
        return apartmentService.saveApartment(apartment);
    };


}

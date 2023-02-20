package com.example.bazyprojekt.service.mongo;

import com.example.bazyprojekt.model.mongo.Address;
import com.example.bazyprojekt.repository.mongoDB.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddresses(){

        return (List<Address>) addressRepository.findAll();

    }

    public Optional<Address> findAddressByID(long id){
        return addressRepository.findById(id);
    }

    public void deleteAddressByID(long id){
        addressRepository.deleteById(id);

    }

    public void deleteAddress(Address address){
        addressRepository.delete(address);

    }

    public Address saveAddress(Address address){
        addressRepository.save(address);
        return address;
    }

    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }


}

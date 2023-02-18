package com.example.bazyprojekt.time.meters;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressTimesMeter {

    @Autowired
    AddressService addressService;

    List<Address> addresses = new ArrayList<>();

    private List<Long> insertTimes = new ArrayList<>();
    private List<Long> deletionTimes = new ArrayList<>();
    private List<Long> retrivalTimes = new ArrayList<>();

    private List<Long> updateTimes = new ArrayList<>();


    public long insertAddressesCheckTimes(List<Address> addressList){

        for(Address address: addressList){
            addressService.saveAddress(address);
            insertTimes.add(addressService.getInsertTime());
        }

        return insertTimes.stream().mapToLong(Long::valueOf).sum();

    }

    public long addressDeletionTimesCalculate(){
        for(Address address: addresses){
            addressService.deleteAddress(address);
            deletionTimes.add(addressService.getDeletionTime());
        }

        return deletionTimes.stream().mapToLong(Long::valueOf).sum();

    }


    public long addressRetrievalCalculateTimes(){
        for(Address address: addresses){
            addressService.findAddressByID(address.getId());
            retrivalTimes.add(addressService.getRetrievalTime());
        }

        return retrivalTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long addressUpdateCalculateTimes(){

        for(Address address: addresses){
            addressService.updateAddress(address);
            updateTimes.add(addressService.getUpdateTime());
        }

        return updateTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long addressGetRowsCalculateTimes(){
        addressService.countRows();
        return addressService.getRowCountTime();
    }
}

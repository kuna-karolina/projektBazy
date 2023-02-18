package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private long insertTime = 0;
    private long deletionTime = 0;
    private long rowCountTime = 0;
    private long deletionByIDTime = 0;
    private long retrievalTime = 0;
    private long updateTime = 0;
    private long findByIDTime = 0;

    public long getRowCountTime() {
        return rowCountTime;
    }

    public long getInsertTime() {
        return insertTime;
    }

    public long getDeletionTime() {
        return deletionTime;
    }

    public long getDeletionByIDTime() {
        return deletionByIDTime;
    }

    public long getRetrievalTime() {
        return retrievalTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public long getFindByIDTime() {
        return findByIDTime;
    }

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddresses() {
        long start = System.currentTimeMillis();
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        long end = System.currentTimeMillis();
        retrievalTime = end - start;
        return addresses;

    }

    public void findAddressByID(long id) {
        long start = System.currentTimeMillis();
        addressRepository.findById(id);
        long end = System.currentTimeMillis();
        findByIDTime = end - start;
    }

    public void deleteAddressByID(long id) {
        long start = System.currentTimeMillis();
        addressRepository.deleteById(id);
        long end = System.currentTimeMillis();
        deletionByIDTime = end - start;


    }

    public void deleteAddress(Address address) {
        long start = System.currentTimeMillis();
        addressRepository.delete(address);
        long end = System.currentTimeMillis();
        deletionTime = end - start;

    }

    public void saveAddress(Address address) {
        long start = System.currentTimeMillis();
        addressRepository.save(address);
        long end = System.currentTimeMillis();
        insertTime = end - start;
    }

    public void updateAddress(Address address) {
        long start = System.currentTimeMillis();
        addressRepository.save(address);
        long end = System.currentTimeMillis();
        updateTime = end - start;

    }

    public long countRows() {
        long start = System.currentTimeMillis();
        long count = addressRepository.count();
        long end = System.currentTimeMillis();
        rowCountTime = end - start;
        return count;

    }


}

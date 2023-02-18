package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentService {

    @Autowired
    ApartmentRepository apartmentRepository;

    private long insertTime = 0;

    private long deletionTime = 0;

    private long retrievalTime = 0;

    private long updateTime = 0;

    private long findByIDTime = 0;

    private long rowCountTime = 0;

    public long getInsertTime() {
        return insertTime;
    }

    public long getDeletionTime() {
        return deletionTime;
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

    public long getRowCountTime() {
        return rowCountTime;
    }

    public List<Apartment> findAllApartments() {
        long start = System.currentTimeMillis();
        List<Apartment> apartments = (List<Apartment>) apartmentRepository.findAll();
        long end = System.currentTimeMillis();
        retrievalTime = end - start;
        return apartments;
    }

    public void findApartmentByID(long id) {
        long start = System.currentTimeMillis();
        apartmentRepository.findById(id);
        long end = System.currentTimeMillis();
        findByIDTime = end - start;

    }

    public void deleteApartmentByID(long id) {
        long start = System.currentTimeMillis();
        apartmentRepository.deleteById(id);
        long end = System.currentTimeMillis();
        deletionTime = end - start;

    }

    public void deleteApartment(Apartment apartment) {
        long start = System.currentTimeMillis();
        apartmentRepository.delete(apartment);
        long end = System.currentTimeMillis();
        deletionTime = end - start;

    }

    public void saveApartment(Apartment apartment) {
        long start = System.currentTimeMillis();
        apartmentRepository.save(apartment);
        long end = System.currentTimeMillis();
        insertTime = end - start;
    }

    public void updateApartment(Apartment apartment) {
        long start = System.currentTimeMillis();
        apartmentRepository.save(apartment);
        long end = System.currentTimeMillis();
        updateTime = end - start;

    }

    public void countRows() {
        long start = System.currentTimeMillis();
        apartmentRepository.count();
        long end = System.currentTimeMillis();
        rowCountTime = end - start;

    }

}

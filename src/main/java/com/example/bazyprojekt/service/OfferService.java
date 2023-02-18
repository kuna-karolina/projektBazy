package com.example.bazyprojekt.service;

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

    private long insertTime = 0;
    private long deletionTime = 0;
    private long retrievalTime = 0;
    private long updateTime = 0;
    private long findByIDTime = 0;

    private long rowCountTime = 0;

    public long getRowCountTime() {
        return rowCountTime;
    }

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

    public List<Offer> findAllOffers(){
        long start = System.currentTimeMillis();
        List<Offer> offers =  (List<Offer>) offerRepository.findAll();
        long end = System.currentTimeMillis();
        retrievalTime = end - start;
        return offers;

    }

    public void findOfferByID(long id){
        long start = System.currentTimeMillis();
        offerRepository.findById(id);
        long end = System.currentTimeMillis();
        retrievalTime = end - start;
    }

    public void deleteOfferByID(long id){
        long start = System.currentTimeMillis();
        offerRepository.deleteById(id);
        long end = System.currentTimeMillis();
        deletionTime = end - start;

    }

    public void deleteOffer(Offer offer){
        long start = System.currentTimeMillis();
        offerRepository.delete(offer);
        long end = System.currentTimeMillis();
        deletionTime = end - start;


    }


    public void saveOffer(Offer offer){
        long start = System.currentTimeMillis();
        offerRepository.save(offer);
        long end = System.currentTimeMillis();
        insertTime = end - start;
    }

    public void updateOffer(Offer offer){
        long start = System.currentTimeMillis();
        offerRepository.save(offer);
        long end = System.currentTimeMillis();
        updateTime = end - start;

    }

    public void countRows() {
        long start = System.currentTimeMillis();
        offerRepository.count();
        long end = System.currentTimeMillis();
        rowCountTime = end - start;

    }

}

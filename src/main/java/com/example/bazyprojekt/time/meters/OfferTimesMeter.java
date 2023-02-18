package com.example.bazyprojekt.time.meters;

import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OfferTimesMeter {

    @Autowired
    OfferService offerService;

    private List<Long> insertTimes = new ArrayList<>();
    private List<Long> deletionTimes = new ArrayList<>();
    private List<Long> retrivalTimes = new ArrayList<>();
    private List<Long> updateTimes = new ArrayList<>();

    private List<Offer> offers = new ArrayList<>();

    public long insertOfferCalculateTimes(){

        for(Offer offer: offers){
            offerService.saveOffer(offer);
            insertTimes.add(offerService.getInsertTime());
        }

        return insertTimes.stream().mapToLong(Long::valueOf).sum();

    }

    public long offerDeletionTimesCalculate(){
        for(Offer offer: offers){
            offerService.deleteOffer(offer);
            deletionTimes.add(offerService.getDeletionTime());
        }

        return deletionTimes.stream().mapToLong(Long::valueOf).sum();

    }


    public long offerRetrievalCalculateTimes(){
        for(Offer offer: offers){
            offerService.findOfferByID(offer.getId());
            retrivalTimes.add(offerService.getRetrievalTime());
        }

        return retrivalTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long offerUpdateCalculateTimes(){

        for(Offer offer: offers){
            offerService.updateOffer(offer);
            updateTimes.add(offerService.getUpdateTime());
        }

        return updateTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long offerGetRowsCalculateTimes(){
        offerService.countRows();
        return offerService.getRowCountTime();
    }

}

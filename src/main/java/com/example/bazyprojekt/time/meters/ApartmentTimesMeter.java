package com.example.bazyprojekt.time.meters;

import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ApartmentTimesMeter {

    @Autowired
    ApartmentService apartmentService;
    private List<Long> insertTimes = new ArrayList<>();
    private List<Long> deletionTimes = new ArrayList<>();
    private List<Long> retrivalTimes = new ArrayList<>();
    private List<Long> updateTimes = new ArrayList<>();
    private List<Apartment> apartments = new ArrayList<>();

    public ApartmentTimesMeter(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public long insertApartmentsCheckTimes(){

        for(Apartment apartment: apartments){
            apartmentService.saveApartment(apartment);
            insertTimes.add(apartmentService.getInsertTime());
        }

        return insertTimes.stream().mapToLong(Long::valueOf).sum();

    }

    public long apartmentDeletionTimesCalculate(){
        for(Apartment apartment: apartments){
            apartmentService.deleteApartment(apartment);
            deletionTimes.add(apartmentService.getDeletionTime());
        }

        return deletionTimes.stream().mapToLong(Long::valueOf).sum();

    }


    public long apartmentRetrievalCalculateTimes(){
        for(Apartment apartment: apartments){
            apartmentService.findApartmentByID(apartment.getId());
            retrivalTimes.add(apartmentService.getFindByIDTime());
        }

        return retrivalTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long addressUpdateCalculateTimes(){

        for(Apartment apartment: apartments){
            apartmentService.updateApartment(apartment);
            updateTimes.add(apartmentService.getUpdateTime());
        }

        return updateTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long apartmentGetRowsCalculateTimes(){
        apartmentService.countRows();
        return apartmentService.getRowCountTime();
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}

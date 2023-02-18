package com.example.bazyprojekt.time.meters;

import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OwnerTimesMeter {

    @Autowired
    OwnerService ownerService;
    List<Owner> owners = new ArrayList<>();
    private List<Long> insertTimes = new ArrayList<>();
    private List<Long> deletionTimes = new ArrayList<>();
    private List<Long> retrivalTimes = new ArrayList<>();

    private List<Long> updateTimes = new ArrayList<>();


    public long insertOwnersCalculateTimes(){

        for(Owner owner: owners){
            ownerService.saveOwner(owner);
            insertTimes.add(ownerService.getInsertTime());
        }

        return insertTimes.stream().mapToLong(Long::valueOf).sum();

    }

    public long ownerDeletionTimesCalculate(){
        for(Owner owner: owners){
            ownerService.deleteOwner(owner);
            deletionTimes.add(ownerService.getDeletionTime());
        }

        return deletionTimes.stream().mapToLong(Long::valueOf).sum();

    }


    public long ownerRetrievalCalculateTimes(){
        for(Owner owner: owners){
            ownerService.findOwnerByID(owner.getId());
            retrivalTimes.add(ownerService.getRetrievalTime());
        }

        return retrivalTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long ownerUpdateCalculateTimes(){

        for(Owner owner: owners){
            ownerService.updateOwner(owner);
            updateTimes.add(ownerService.getUpdateTime());
        }

        return updateTimes.stream().mapToLong(Long::valueOf).sum();
    }

    public long ownerGetRowsCalculateTimes(){
        ownerService.countRows();
        return ownerService.getRowCountTime();
    }

}

package com.example.bazyprojekt.service;

import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

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

    public void findAllOwners(){
        long start = System.currentTimeMillis();
        List<Owner> owners = (List<Owner>) ownerRepository.findAll();
        long end = System.currentTimeMillis();
        retrievalTime = end - start;
    }

    public void findOwnerByID(long id){
        long start = System.currentTimeMillis();
        ownerRepository.findById(id);
        long end = System.currentTimeMillis();
        retrievalTime = end - start;

    }

    public void deleteOwnerByID(long id){
        long start = System.currentTimeMillis();
        ownerRepository.deleteById(id);
        long end = System.currentTimeMillis();
        deletionTime = end - start;

    }

    public void deleteOwner(Owner owner){
        long start = System.currentTimeMillis();
        ownerRepository.delete(owner);
        long end = System.currentTimeMillis();
        deletionTime = end - start;


    }
    public void saveOwner(Owner owner){
        long start = System.currentTimeMillis();
        ownerRepository.save(owner);
        long end = System.currentTimeMillis();
        insertTime = end - start;
    }

    public void updateOwner(Owner owner){
        long start = System.currentTimeMillis();
        owner =  ownerRepository.save(owner);
        long end = System.currentTimeMillis();
        updateTime = end - start;

    }

    public void countRows() {
        long start = System.currentTimeMillis();
        ownerRepository.count();
        long end = System.currentTimeMillis();
        rowCountTime = end - start;

    }


}

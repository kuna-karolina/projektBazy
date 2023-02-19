package com.example.bazyprojekt;

import com.example.bazyprojekt.helpers.CsvReader;
import com.example.bazyprojekt.helpers.ObjectMapper;
import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.model.sql.Owner;
import com.example.bazyprojekt.time.meters.AddressTimesMeter;
import com.example.bazyprojekt.time.meters.ApartmentTimesMeter;
import com.example.bazyprojekt.time.meters.OfferTimesMeter;
import com.example.bazyprojekt.time.meters.OwnerTimesMeter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class BazyProjektApplication {


    public static void main(String[] args) throws FileNotFoundException, ParseException {


        ApplicationContext app  = SpringApplication.run(BazyProjektApplication.class, args);


        // ADDRESS

        List<String[]> data = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\address.csv");
        List<Address> addresses = ObjectMapper.convertCsvToAddressList(data);
        AddressTimesMeter addressTimesMeter = app.getBean(AddressTimesMeter.class);
        addressTimesMeter.setAddresses(addresses);
        long insertTime = addressTimesMeter.insertAddressesCheckTimes();
        System.out.println("Address insert time:" + insertTime);
        long getRowCountTime = addressTimesMeter.addressGetRowsCalculateTimes();
        System.out.println("Address get row count time:" + getRowCountTime);
        long retrievalTime = addressTimesMeter.addressRetrievalCalculateTimes();
        System.out.println("Address retrieval time:" + retrievalTime);


       //OWNER

        List<String[]> ownerCSV = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\owner.csv");
        List<Owner> owners = ObjectMapper.convertCsvToOwnerList(ownerCSV,addresses);
        OwnerTimesMeter ownerTimesMeter = app.getBean(OwnerTimesMeter.class);

        ownerTimesMeter.setOwners(owners);
        insertTime = ownerTimesMeter.insertOwnersCalculateTimes();
        System.out.println("Owner insert time:" + insertTime);
        getRowCountTime = ownerTimesMeter.ownerGetRowsCalculateTimes();
        System.out.println("Owner get row count time:" + getRowCountTime);
        retrievalTime = ownerTimesMeter.ownerRetrievalCalculateTimes();
        System.out.println("Owner retrieval time:" + retrievalTime);

        // APARTMENT

        List<String[]> apartmentsCSV = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\apartment.csv");
        List<Apartment> apartments = ObjectMapper.convertCsvToApartmentList(apartmentsCSV,addresses,owners);
        ApartmentTimesMeter apartmentTimesMeter = app.getBean(ApartmentTimesMeter.class);

        apartmentTimesMeter.setApartments(apartments);
        insertTime = apartmentTimesMeter.insertApartmentsCheckTimes();
        System.out.println("Apartment insert time:" + insertTime);
        getRowCountTime = apartmentTimesMeter.apartmentGetRowsCalculateTimes();
        System.out.println("Apartment get row count time:" + getRowCountTime);
        retrievalTime = apartmentTimesMeter.apartmentRetrievalCalculateTimes();
        System.out.println("Apartment retrieval time:" + retrievalTime);

        //OFFER

        List<String[]> offersCSV = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\offer.csv");
        List<Offer> offers = ObjectMapper.convertCsvToOfferList(offersCSV,apartments);

        OfferTimesMeter offerTimesMeter = app.getBean(OfferTimesMeter.class);
        offerTimesMeter.setOffers(offers);
        insertTime = offerTimesMeter.insertOfferCalculateTimes();
        System.out.println("Offer insert time:" + insertTime);
        getRowCountTime = offerTimesMeter.offerGetRowsCalculateTimes();
        System.out.println("Offer get row count time:" + getRowCountTime);
        retrievalTime = offerTimesMeter.offerRetrievalCalculateTimes();
        System.out.println("Offer retrieval time:" + retrievalTime);


        // UPDATES
        List<String[]> updatedAddresses = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\updated_address.csv");
        addresses = ObjectMapper.convertCsvToAddressList(updatedAddresses);
        addressTimesMeter.setAddresses(addresses);
        long updateTime = addressTimesMeter.addressUpdateCalculateTimes();
        System.out.println("Address update time:" + updateTime);

        List<String[]> updatedOwners = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\updated_owners.csv");
        owners = ObjectMapper.convertCsvToOwnerList(updatedOwners,addresses);
        ownerTimesMeter.setOwners(owners);
        updateTime = ownerTimesMeter.ownerUpdateCalculateTimes();
        System.out.println("Owner update time:" + updateTime);

        List<String[]> updatedApartments = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\updated_apartments.csv");
        apartments = ObjectMapper.convertCsvToApartmentList(updatedApartments,addresses,owners);
        apartmentTimesMeter.setApartments(apartments);
        updateTime = addressTimesMeter.addressUpdateCalculateTimes();
        System.out.println("Apartment update time:" + updateTime);


        List<String[]> updatedOffers = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\updated_offers.csv");
        offers = ObjectMapper.convertCsvToOfferList(updatedOffers,apartments);
        offerTimesMeter.setOffers(offers);
        updateTime = offerTimesMeter.offerUpdateCalculateTimes();
        System.out.println("Offer update time:" + updateTime);


        //DELETES

        for(Owner owner : owners){
            owner.setAddress(null);
        }
        for(Apartment apartment : apartments){
            apartment.setAddress(null);
        }
        ownerTimesMeter.setOwners(owners);
        ownerTimesMeter.ownerUpdateCalculateTimes();
        apartmentTimesMeter.setApartments(apartments);
        apartmentTimesMeter.addressUpdateCalculateTimes();

        long deleteTime = addressTimesMeter.addressDeletionTimesCalculate();
        System.out.println("Address deletion time:" + deleteTime);


        for(Apartment apartment : apartments){
            apartment.setOwner(null);
        }

        apartmentTimesMeter.setApartments(apartments);
        apartmentTimesMeter.addressUpdateCalculateTimes();
        deleteTime = ownerTimesMeter.ownerDeletionTimesCalculate();
        System.out.println("Owner deletion time:" + deleteTime);


        for(Offer offer : offers){
            offer.setApartment(null);
        }
        offerTimesMeter.setOffers(offers);
        offerTimesMeter.offerUpdateCalculateTimes();

        deleteTime = apartmentTimesMeter.apartmentDeletionTimesCalculate();
        System.out.println("Apartment deletion time:" + deleteTime);

        deleteTime = offerTimesMeter.offerDeletionTimesCalculate();
        System.out.println("Offer deletion time:" + deleteTime);



    }
}

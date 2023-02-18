package com.example.bazyprojekt.helpers;

import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Apartment;
import com.example.bazyprojekt.model.sql.Offer;
import com.example.bazyprojekt.model.sql.Owner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectMapper {


    public static List<Address> convertCsvToAddressList(List<String[]> records) {
        List<Address> addresses = new ArrayList<>();
        for (String[] fields : records) {
            int id = Integer.parseInt(fields[0]);
            String streetName = fields[1];
            String city = fields[2];
            String buildingNr = fields[3];
            String postalCode = fields[4];
            String apartmentNr = fields[5];
            Address address = new Address(id, streetName, city, buildingNr, postalCode, apartmentNr);
            addresses.add(address);
        }
        return addresses;
    }


    public static List<Offer> convertCsvToOfferList(List<String[]> records) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Offer> offers = new ArrayList<>();
        for (String[] fields : records) {
            int id = Integer.parseInt(fields[0]);
            Date creationDate = formatter.parse(fields[1]);
            boolean negotiable = Boolean.parseBoolean(fields[2]);
            String description = fields[3];
            Double agencyFee = Double.valueOf(fields[4]);
            String title = fields[5];
            Offer offer = new Offer(id, creationDate, negotiable, description, agencyFee, title);
            offers.add(offer);
        }
        return offers;
    }

    public static List<Apartment> convertCsvToApartmentList(List<String[]> records) throws ParseException {
        List<Apartment> apartments = new ArrayList<>();
        for (String[] fields : records) {
            int id = Integer.parseInt(fields[0]);
            double area = Double.parseDouble(fields[1]);
            String creationYear = fields[2];
            String lastRenovationYear = fields[3];
            String buildingType = fields[4];
            boolean isFurnished = Boolean.parseBoolean(fields[5]);
            String roomsCount = fields[6];
            Apartment apartment = new Apartment(id, area, creationYear, lastRenovationYear, buildingType, isFurnished,roomsCount);
            apartments.add(apartment);
        }
        return apartments;
    }


    public static List<Owner> convertCsvToOwnerList(List<String[]> records) throws ParseException {
        List<Owner> owners = new ArrayList<>();
        for (String[] fields : records) {
            int id = Integer.parseInt(fields[0]);
            String name = fields[1];
            String surname = fields[2];
            String phoneNumber = fields[3];
            String emailAddress = fields[4];
            String companyName = fields[5];
            Owner owner = new Owner(id, name, surname, phoneNumber, emailAddress, companyName);
            owners.add(owner);
        }
        return owners;
    }

}

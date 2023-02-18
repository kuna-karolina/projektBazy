package com.example.bazyprojekt;

import com.example.bazyprojekt.helpers.CsvReader;
import com.example.bazyprojekt.helpers.ObjectMapper;
import com.example.bazyprojekt.model.sql.Address;
import com.example.bazyprojekt.model.sql.Offer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class BazyProjektApplication {


    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SpringApplication.run(BazyProjektApplication.class, args);
        List<String[]> data = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\address.csv");
        List<Address> addresses = ObjectMapper.convertCsvToAddressList(data);
//        for(Address address : addresses){
//            System.out.println(address.toString());
//        }

        List<String[]> offersCSV = CsvReader.readCsv("C:\\Users\\user\\IdeaProjects\\bazyProjekt\\src\\main\\java\\com\\example\\bazyprojekt\\csv\\offer3.csv");
        List<Offer> offers = ObjectMapper.convertCsvToOfferList(offersCSV);
        for (Offer offer : offers) {
            System.out.println(offer.toString());
        }


    }
}

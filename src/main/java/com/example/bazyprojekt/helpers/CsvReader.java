package com.example.bazyprojekt.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    public static List<String[]> readCsv(String filePath) throws FileNotFoundException {
        List<String[]> records = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        // pomiń pierwszy wiersz (nagłówki kolumn)
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            records.add(scanner.nextLine().split(","));
        }
        scanner.close();
        return records;
    }

}

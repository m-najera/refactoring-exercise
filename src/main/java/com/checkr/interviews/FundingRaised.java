package com.checkr.interviews;

import java.util.*;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class FundingRaised {

    public static List<Row> readFile(String path) throws IOException {
        List<Row> csvData = new ArrayList<Row>();
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] row = null;
        Row newRow;
        while ((row = reader.readNext()) != null) {
            newRow = new Row(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
            csvData.add(newRow);
        }
        reader.close();
        csvData.remove(0);
        return csvData;
    }

    public static List<Row> where(Row filter) throws IOException {
        List<Row> csvData = readFile("startup_funding.csv");
        List<Row> results = new ArrayList<Row>();
        for (int i = 0; i < csvData.size(); i++) {
            if (csvData.get(i).rowMatchesFilters(filter)) {
                results.add(csvData.get(i));
            }
        }
        return results;
    }

    public static Row findBy(Row filter) throws IOException, NoSuchEntryException {
        List<Row> csvData = readFile("startup_funding.csv");
        for (int i = 0; i < csvData.size(); i++) {
            if (csvData.get(i).rowMatchesFilters(filter)) {
                return csvData.get(i);
            }
        }
        throw new NoSuchEntryException();
    }

    public static void main(String[] args) {
        try {
            Row filter = new Row();
            filter.company_name = "Facebook";
            filter.round = "a";
            System.out.print(FundingRaised.where(filter).size());
        } catch (Exception e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

class NoSuchEntryException extends Exception {
}
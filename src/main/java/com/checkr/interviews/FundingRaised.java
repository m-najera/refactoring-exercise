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

    public static List<Row> where(Map<String, String> options) throws IOException {
        
        List<Row> csvData = readFile("startup_funding.csv");
        
        if (options.containsKey("company_name")) {
            List<Row> results = new ArrayList<Row>();
            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i).company_name.equals(options.get("company_name"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("city")) {
            List<Row> results = new ArrayList<Row>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i).city.equals(options.get("city"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("state")) {
            List<Row> results = new ArrayList<Row>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i).state.equals(options.get("state"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("round")) {
            List<Row> results = new ArrayList<Row>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i).round.equals(options.get("round"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        return csvData;
    }

    public static Row findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<Row> csvData = readFile("startup_funding.csv");
        Row result = new Row();

        for (int i = 0; i < csvData.size(); i++) {
            if (options.containsKey("company_name")) {
                if (csvData.get(i).company_name.equals(options.get("company_name"))) {
                    result = csvData.get(i);
                } else {
                    continue;
                }
            }

            if (options.containsKey("city")) {
                if (csvData.get(i).city.equals(options.get("city"))) {
                    result = csvData.get(i);
                } else {
                    continue;
                }
            }

            if (options.containsKey("state")) {
                if (csvData.get(i).state.equals(options.get("state"))) {
                    result = csvData.get(i);
                } else {
                    continue;
                }
            }

            if (options.containsKey("round")) {
                if (csvData.get(i).round.equals(options.get("round"))) {
                    result = csvData.get(i);
                } else {
                    continue;
                }
            }

            return result;
        }

        throw new NoSuchEntryException();
    }

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<String, String>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(FundingRaised.where(options).size());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

class NoSuchEntryException extends Exception {
}

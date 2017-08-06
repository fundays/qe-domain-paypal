package com.sandbox.custom;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JavaCSV {

    /**
     * Read CSV
     */
    public ArrayList<String[]> readCSV(String csvFilePath) throws Exception {
        ArrayList<String[]> csvList = new ArrayList<>();
        CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("SJIS"));
        reader.readHeaders();
        while (reader.readRecord()) {
            csvList.add(reader.getValues());
        }
        reader.close();
        return csvList;
    }

    /**
     * Write to CSV
     */
    public void writeCsv() {
        try {

            String csvFilePath = "c:/test.csv";
            CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("SJIS"));
            String[] contents = {"restTest", "5005"};
            wr.writeRecord(contents);
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> arr = readeCsv();
        System.out.println(arr.get(0)[0]);
    }

    public static ArrayList<String[]> readeCsv() throws Exception {
        ArrayList<String[]> csvList = new ArrayList<String[]>();
        String csvFilePath = "src/test/resources/testFile.csv";
        CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("SJIS"));
        reader.readHeaders(); // ignore Headers

        while (reader.readRecord()) { //Read by Line
            csvList.add(reader.getValues());
        }
        reader.close();

        for (int row = 0; row < csvList.size(); row++) {

            String cell = csvList.get(row)[0]; //get row / col
            String col = csvList.get(row)[1];
            System.out.println(cell + " " + col);

        }
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

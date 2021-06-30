package main.java.com.delphi.app;

import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) throws IllegalAccessException {
        CSVParser csv = new CSVParser();
        List<CD> cds = XMLParser.append(XML_FILE_PATH);
        System.out.println(cds.get(1).getValue("ARTIST"));
    }
}


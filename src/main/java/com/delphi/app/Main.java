package main.java.com.delphi.app;

import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) {
        CSVParser csv = new CSVParser();
        List<CD> cds = AppendElements.append(XML_FILE_PATH);
        for (CD cd : cds) {
            csv.parse(cd.getRow(), CSV_FILE_PATH);
        }
    }
}


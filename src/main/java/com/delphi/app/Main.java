package main.java.com.delphi.app;


import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) {
        CSVParser csv = new CSVParser();
        CD c = new CD();
        List<CD> cds = AppendElements.append(XML_FILE_PATH);
        csv.parse(c.getColumns(cds), CSV_FILE_PATH);
    }
}


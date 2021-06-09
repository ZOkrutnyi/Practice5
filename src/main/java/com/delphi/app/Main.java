package main.java.com.delphi.app;

import java.util.List;

public class Main {
    private static final String XML_FILE_PATH = "cd_catalog.xml";
    private static final String CSV_FILE_PATH = "newCSV.csv";
    public static final List<CD> ELEMENTS = AppendElements.append(XML_FILE_PATH);
    public static void main(String[] args) {
        ParseCSV parseCSV = new ParseCSV();
        CD cds = new CD();
        parseCSV.parseToCSV(cds.getColumns(),CSV_FILE_PATH);
    }
}

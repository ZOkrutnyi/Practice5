package main.java.com.delphi.app.main;

import main.java.com.delphi.app.columnData.CD;
import main.java.com.delphi.app.parsers.CSVParser;
import main.java.com.delphi.app.parsers.XLSParser;
import main.java.com.delphi.app.parsers.XLSXParser;
import main.java.com.delphi.app.parsers.XMLParser;

import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";
    private static final String XLS_FILE_PATH = "newCSV.xls";
    private static final String XLSX_FILE_PATH = "newCSV.xlsx";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) {
        XLSParser xls = new XLSParser();
        CSVParser csv = new CSVParser();
        XLSXParser xlsxParser = new XLSXParser();
        List<CD> cds = XMLParser.append(XML_FILE_PATH);
//        xls.parse(cds.get(1).getRow(),XLS_FILE_PATH);
        csv.parse(cds.get(1).getRow(),CSV_FILE_PATH);
        xlsxParser.parse(cds.get(1).getRow(),XLSX_FILE_PATH);
    }
}


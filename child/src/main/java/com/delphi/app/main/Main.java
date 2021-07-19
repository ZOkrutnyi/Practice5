package com.delphi.app.main;

import com.delphi.app.columnData.CD;
import com.delphi.app.parsers.*;
import com.delphi.app.writers.XLSXWriter;

import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";
    private static final String XLS_FILE_PATH = "newXLS.xls";
    private static final String XLSX_FILE_PATH = "newXLSX.xlsx";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) {
//        XLSParser xls = new XLSWriter();
//        CSVParser csv = new CSVWriter();
        XLSXWriter xlsxWriter = new XLSXWriter();
        List<CD> cds = XMLParser.append(XML_FILE_PATH);
//        xls.parse(cds.get(1).getRow(),XLS_FILE_PATH);
//        csv.parse(cds.get(1).getRow(),CSV_FILE_PATH);
        xlsxWriter.write(cds.get(2).getRow(),XLS_FILE_PATH);
    }
}


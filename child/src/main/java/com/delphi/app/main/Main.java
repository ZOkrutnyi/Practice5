package com.delphi.app.main;

import com.delphi.app.column_data.CD;
import com.delphi.app.parsers.*;
import com.delphi.app.writers.AbstractWriter;
import com.delphi.app.writers.CSVWriter;
import com.delphi.app.writers.XLSWriter;
import com.delphi.app.writers.XLSXWriter;

public class Main {
    @SuppressWarnings("unused")
    private static final String CSV_FILE_PATH = "newCSV.csv";
    @SuppressWarnings("unused")
    private static final String XLS_FILE_PATH = "newXLS.xls";
    @SuppressWarnings("unused")
    private static final String XLSX_FILE_PATH = "newXLSX.xlsx";
    private static final String XML_FILE_PATH = "cd_catalog.xml";

    public static void main(String[] args) {
        String pathToWrite = "XLS_FILE_PATH";
        AbstractWriter writer = getWriterByPath(pathToWrite);
        for (CD cd: XMLParser.append(XML_FILE_PATH)) {
            writer.write(cd.getRow(),pathToWrite);
        }
    }

    static AbstractWriter getWriterByPath(String path) {
        if (path.contains(".csv")) {
            return new CSVWriter();
        }
        else if (path.contains(".xlsx")) {
            return new XLSXWriter();
        }
        else if (path.contains(".xls")) {
            return new XLSWriter();
        } else {
            throw new IllegalArgumentException("illegal format");
        }
    }
}

package com.delphi.app.main;

import com.delphi.app.factory.AbstractFactory;
import com.delphi.app.factory.FactoryXML;
import com.delphi.app.parsers.Parser;
import com.delphi.app.readers.Reader;
import com.delphi.app.writers.Writer;

import java.io.File;

public class Main {
    @SuppressWarnings("unused")
    private static final String CSV_FILE_PATH = "newCSV.csv";
    @SuppressWarnings("unused")
    private static final String XLS_FILE_PATH = "newXLS.xls";
    @SuppressWarnings("unused")
    private static final String XLSX_FILE_PATH = "newXLSX.xlsx";
    private static final String XML_FILE_PATH = "catalog_CD.xml";

    public static void main(String[] args) {
        AbstractFactory xmlFactory = new FactoryXML(CSV_FILE_PATH, CSV_FILE_PATH);
        Parser parser = xmlFactory.createParser();
        Writer writer = xmlFactory.createWriter();
        Reader reader = xmlFactory.creteReader();
        CDParserExecutor executor = new CDParserExecutor(parser, writer, reader);
        executor.execute();
    }
}


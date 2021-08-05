package com.delphi.app.main;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.factory.AbstractFactory;
import com.delphi.app.factory.XMLFactory;
import com.delphi.app.parsers.Parser;
import com.delphi.app.writers.Writer;

public class Main {
    @SuppressWarnings("unused")
    private static final String CSV_FILE_PATH = "newCSV.csv";
    @SuppressWarnings("unused")
    private static final String XLS_FILE_PATH = "newXLS.xls";
    @SuppressWarnings("unused")
    private static final String XLSX_FILE_PATH = "newXLSX.xlsx";
    private static final String XML_FILE_PATH = "catalog_CD.xml";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AbstractFactory xmlFactory = new XMLFactory(XML_FILE_PATH,CSV_FILE_PATH);
        Parser<? extends AbstractColumnData> parser = xmlFactory.createParser();
        Writer writer = xmlFactory.createWriter();
        CDParserExecutor.execute(parser, writer);
        System.out.println(System.currentTimeMillis() - start);
    }
}


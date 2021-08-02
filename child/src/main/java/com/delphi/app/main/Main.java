package com.delphi.app.main;

import com.delphi.app.parsers.*;
import com.delphi.app.readers.Reader;
import com.delphi.app.readers.ReaderFactory;
import com.delphi.app.writers.*;

public class Main {
    @SuppressWarnings("unused")
    private static final String CSV_FILE_PATH = "newCSV.csv";
    @SuppressWarnings("unused")
    private static final String XLS_FILE_PATH = "newXLS.xls";
    @SuppressWarnings("unused")
    private static final String XLSX_FILE_PATH = "newXLSX.xlsx";
    private static final String XML_FILE_PATH = "catalog_CD.xml";

    public static void main(String[] args) {
        ReaderFactory readerFactory = new ReaderFactory(XML_FILE_PATH);
        Reader reader = readerFactory.createReader();
        ParserFactory parserFactory = new ParserFactory(XML_FILE_PATH);
        Parser parser = parserFactory.createParser();
        WriterFactory writerFactory = new WriterFactory(CSV_FILE_PATH);
        Writer writer = writerFactory.createWriter();
        System.out.println(reader.byteToString(reader.read()));
//        CDParserExecutor.execute(parser,writer);
    }
}


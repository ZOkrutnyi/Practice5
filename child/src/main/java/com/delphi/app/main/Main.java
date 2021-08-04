package com.delphi.app.main;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.*;
import com.delphi.app.readers.Reader;
import com.delphi.app.readers.ReaderImpl;
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
        long start = System.currentTimeMillis();
        Reader reader = new ReaderImpl(XLS_FILE_PATH);
        ParserFactory parserFactory = new ParserFactory(reader);
        Parser<? extends AbstractColumnData> parser = parserFactory.createParser();
        WriterFactory writerFactory = new WriterFactory(CSV_FILE_PATH);
        Writer writer = writerFactory.createWriter();
        CDParserExecutor.execute(parser, writer);
        System.out.println(System.currentTimeMillis() - start);
    }
}


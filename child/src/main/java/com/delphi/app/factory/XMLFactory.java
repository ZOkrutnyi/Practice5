package com.delphi.app.factory;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.Parser;
import com.delphi.app.parsers.XMLParserCD;
import com.delphi.app.readers.Reader;
import com.delphi.app.readers.ReaderImpl;
import com.delphi.app.writers.Writer;
import com.delphi.app.writers.CSVWriter;
import com.delphi.app.writers.XLSWriter;
import com.delphi.app.writers.XLSXWriter;

public class XMLFactory implements AbstractFactory {
    private final String pathToRead;
    private final String pathToWrite;

    public XMLFactory(String pathToRead, String pathToWrite) {
        if (pathToRead.contains(".xml")) {
            this.pathToRead = pathToRead;
        } else {
            throw new IllegalArgumentException("filepath is not correct");
        }
        this.pathToWrite = pathToWrite;
    }

    public Reader createReader() {
        return new ReaderImpl(pathToRead);
    }

    @Override
    public Writer createWriter() {
        return selectWriterByPath();
    }

    @Override
    public Parser<? extends AbstractColumnData> createParser() {
        return new XMLParserCD(createReader());
    }

    private Writer selectWriterByPath() {
        if (pathToWrite.contains(".csv"))
            return new CSVWriter(pathToWrite);
        else if (pathToWrite.contains(".xlsx"))
            return new XLSXWriter(pathToWrite);
        else if (pathToWrite.contains(".xls"))
            return new XLSWriter(pathToWrite);
        else
            throw new IllegalArgumentException();
    }
}

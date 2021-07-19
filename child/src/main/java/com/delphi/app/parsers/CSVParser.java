package com.delphi.app.parsers;

public class CSVParser extends AbstractParser{
    @Override
    protected void setDefaultDelimiter() {
        defaultDelimiter = ';';
    }
}

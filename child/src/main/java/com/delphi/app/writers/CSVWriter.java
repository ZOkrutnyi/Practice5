package com.delphi.app.writers;

public class CSVWriter extends AbstractWriter {
    @Override
    protected void setDefaultDelimiter() {
        defaultDelimiter = ';';
    }
}

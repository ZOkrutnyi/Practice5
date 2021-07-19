package com.delphi.app.writers;

public class XLSWriter extends AbstractWriter {

    @Override
    protected void setDefaultDelimiter() {
        defaultDelimiter = '\t';
    }
}

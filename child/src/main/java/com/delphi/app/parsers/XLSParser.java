package com.delphi.app.parsers;

public class XLSParser extends AbstractParser{

    @Override
    protected void setDefaultDelimiter() {
        defaultDelimiter = '\t';
    }
}

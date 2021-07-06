package main.java.com.delphi.app.parsers;

public class XLSParser extends AbstractParser{

    @Override
    protected void setDefaultDelimiter() {
        DEFAULT_DELIMITER = '\t';
    }
}

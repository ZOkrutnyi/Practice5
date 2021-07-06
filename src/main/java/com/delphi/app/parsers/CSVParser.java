package main.java.com.delphi.app.parsers;

public class CSVParser extends AbstractParser{
    @Override
    protected void setDefaultDelimiter() {
        DEFAULT_DELIMITER = ';';
    }
}

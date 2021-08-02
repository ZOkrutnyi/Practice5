package com.delphi.app.parsers;

public class ParserFactory {
    private final String filepath;
    public ParserFactory(String filepath)
    {
        this.filepath = filepath;
    }
    public Parser createParser()
    {
        if(filepath.contains(".xml"))
            return new XMLParserCD(filepath);
        else throw new IllegalArgumentException("Parser format not recognised");
    }
}

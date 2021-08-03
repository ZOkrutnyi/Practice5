package com.delphi.app.parsers;

import com.delphi.app.readers.Reader;

public class ParserFactory {
    private final Reader reader;

    public ParserFactory(Reader reader) {
        this.reader = reader;
    }

    public Parser createParser() {
        return new XMLParserCD(reader);
    }
}

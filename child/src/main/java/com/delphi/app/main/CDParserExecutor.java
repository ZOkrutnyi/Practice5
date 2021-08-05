package com.delphi.app.main;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.Parser;
import com.delphi.app.readers.Reader;
import com.delphi.app.writers.Writer;

public class CDParserExecutor {
    private final Parser parser;
    private final Writer writer;
    private final Reader reader;

    public CDParserExecutor(Parser parser, Writer writer, Reader reader) {
        this.parser = parser;
        this.writer = writer;
        this.reader = reader;
    }

    public void execute() {
        String inputText = reader.byteToString(reader.read());
        for (AbstractColumnData ab : parser.parse(inputText)) {
            writer.write(ab.getRow());
        }
    }
}

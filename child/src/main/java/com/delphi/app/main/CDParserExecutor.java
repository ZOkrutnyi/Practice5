package com.delphi.app.main;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.Parser;
import com.delphi.app.writers.Writer;

public class CDParserExecutor {
    private CDParserExecutor() {
    }

    public static void execute(Parser parser, Writer writer) {
        for (AbstractColumnData ab : parser.parse()) {
            writer.write(ab.getRow());
        }
    }
}

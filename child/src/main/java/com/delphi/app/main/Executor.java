package com.delphi.app.main;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.Parser;
import com.delphi.app.writers.Writer;

public class Executor {
    private Executor() {}
    public static void execute(Parser parser, Writer writer)
    {
        for (AbstractColumnData ab: parser.append()) {
            writer.write(ab.getRow());
        }
    }
}

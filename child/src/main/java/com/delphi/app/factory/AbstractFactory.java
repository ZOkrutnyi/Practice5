package com.delphi.app.factory;

import com.delphi.app.data.AbstractColumnData;
import com.delphi.app.parsers.Parser;
import com.delphi.app.writers.Writer;

public interface AbstractFactory {
    Parser<? extends AbstractColumnData> createParser();
    Writer createWriter();
}

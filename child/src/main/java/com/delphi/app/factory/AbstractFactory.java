package com.delphi.app.factory;

import com.delphi.app.parsers.Parser;
import com.delphi.app.readers.Reader;
import com.delphi.app.writers.Writer;

public interface AbstractFactory {
    Parser createParser();
    Writer createWriter();
    Reader creteReader();
}

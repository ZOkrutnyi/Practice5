package com.delphi.app.parsers;

import com.delphi.app.data.AbstractColumnData;

import java.util.List;


public interface Parser<E extends AbstractColumnData> {
    List<E> parse();
}

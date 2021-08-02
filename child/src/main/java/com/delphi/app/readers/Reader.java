package com.delphi.app.readers;

import java.util.List;

public interface Reader {
    List<Byte> read();
    String byteToString(List<Byte> list);
}

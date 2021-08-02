package com.delphi.app.readers;


public class ReaderFactory {
    private final String filepath;
    public ReaderFactory(String filepath) {
        this.filepath = filepath;
    }
    public Reader createReader() {
        if(filepath.contains(".xml"))
            return new XMLReader(filepath);
        else
            throw new IllegalArgumentException();
    }
}

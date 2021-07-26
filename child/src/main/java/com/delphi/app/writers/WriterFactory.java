package com.delphi.app.writers;

public class WriterFactory {
    private final String filepath;

    public WriterFactory(String filepath) {
        this.filepath = filepath;
    }

    public Writer createWriter() {
        if (filepath.contains(".csv")) {
            return new CSVWriter(filepath);
        } else if (filepath.contains(".xlsx")) {
            return new XLSXWriter(filepath);
        } else if (filepath.contains(".xls")) {
            return new XLSWriter(filepath);
        } else {
            throw new IllegalArgumentException("illegal format");
        }
    }
}

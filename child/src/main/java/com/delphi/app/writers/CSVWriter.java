package com.delphi.app.writers;

import java.io.FileWriter;
import java.io.IOException;

class CSVWriter implements Writer {
    private static final char DELIMITER = ';';
    private final String filepath;

    protected CSVWriter(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void write(String[] strings) {
        try (FileWriter fw = new FileWriter(filepath, true)) {
            for (String string : strings) {
                fw.append(string).append(DELIMITER);
            }
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

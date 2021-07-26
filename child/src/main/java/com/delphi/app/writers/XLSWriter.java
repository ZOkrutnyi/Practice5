package com.delphi.app.writers;

import java.io.FileWriter;
import java.io.IOException;

class XLSWriter implements Writer {

    private static final char DELIMITER = '\t';
    private final String filepath;

    protected XLSWriter(String filepath)
    {
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

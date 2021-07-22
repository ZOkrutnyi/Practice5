package com.delphi.app.writers;


import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractWriter {
    char defaultDelimiter;
    @SuppressWarnings("unused")
    public void write(String[] strings, String filename) {
        setDefaultDelimiter(';');
        try (FileWriter fw = new FileWriter(filename, true)) {
            for (String string : strings) {
                fw.append(string).append(defaultDelimiter);
            }
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setDefaultDelimiter(char delimiter) {
        this.defaultDelimiter = delimiter;
    }
}


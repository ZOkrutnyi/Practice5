package com.delphi.app.writers;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractWriter {
    char defaultDelimiter;
    @SuppressWarnings("unused")
    public void write(String str, String filename) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.append(str).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public void write(String[] strings, String filename) throws IOException {
        setDefaultDelimiter();
        try (FileWriter fw = new FileWriter(filename, true)) {
            for (int i = 0; i<strings.length;i++) {
                if(i==strings.length-1) {
                    fw.append(strings[i]).append("\n");
                    break;
                }
                fw.append(strings[i]).append(defaultDelimiter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setDefaultDelimiter() {
    }
}


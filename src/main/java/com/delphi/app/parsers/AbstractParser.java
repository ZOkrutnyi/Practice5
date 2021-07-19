package main.java.com.delphi.app.parsers;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractParser {
    char DEFAULT_DELIMITER;
    @SuppressWarnings("unused")
    public void parse(String str, String filename) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.append(str).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public void parse(String[] strings, String filename) {
        setDefaultDelimiter();
        try (FileWriter fw = new FileWriter(filename, true)) {
            for (int i = 0; i<strings.length;i++) {
                if(i==strings.length-1) {
                    fw.append(strings[i]).append("\n");
                    break;
                }
                fw.append(strings[i]).append(DEFAULT_DELIMITER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setDefaultDelimiter() {
    }
}


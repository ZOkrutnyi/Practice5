package main.java.com.delphi.app;

import java.io.FileWriter;
import java.io.IOException;

public class CSVParser {
    @SuppressWarnings("unused")
    public void parse(String str, String filename) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.append(str).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public void parse(String[] strings, String filename) {

        try (FileWriter fw = new FileWriter(filename, true)) {
            for (int i = 0; i<strings.length;i++) {
                if(i==strings.length-1) {
                    fw.append(strings[i]).append("\n");
                    break;
                }
                fw.append(strings[i]).append(';');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


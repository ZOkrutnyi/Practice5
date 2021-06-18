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
            for (String s : strings) {
                fw.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


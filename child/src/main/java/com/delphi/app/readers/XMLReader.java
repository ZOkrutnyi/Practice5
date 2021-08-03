package com.delphi.app.readers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLReader implements Reader {
    private final String filepath;

    XMLReader(String filepath) {
        try {
            System.setErr(new PrintStream("log.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.filepath = filepath;
    }

    @Override
    public List<Byte> read() {
        List<Byte> byteArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filepath)))) {
            while (br.ready()) {
                byteArray.add((byte) br.read());
            }
        } catch (IOException e) {
            System.err.println("XML Reader read error");
        }
        return byteArray;
    }

    @Override
    public String byteToString(List<Byte> list) {
        StringBuilder sb = new StringBuilder();
        for (byte b: list) {
            if(b == '\n')
                sb.append('\n');
            else
                sb.append((char) b);
        }
        return sb.toString();
    }
}

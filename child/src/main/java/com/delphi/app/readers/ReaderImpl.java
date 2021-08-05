package com.delphi.app.readers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderImpl implements Reader {
    private final String filepath;
    Logger logger = Logger.getLogger(this.getClass().getName());
    FileHandler fileHandler;

    public ReaderImpl(String filepath) {
        this.filepath = filepath;
        try {
            if(!new File(this.getClass().getSimpleName() + ".log").exists()) {
                fileHandler = new FileHandler(this.getClass().getSimpleName() + ".log", true);
                logger.addHandler(fileHandler);
            }
        } catch (IOException e) {
            logger.log(Level.INFO, "initialize handler error");
        }
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
            logger.log(Level.INFO, "read method failed to read");
        }
        return byteArray;
    }

    @Override
    public String byteToString(List<Byte> list) {
        StringBuilder sb = new StringBuilder();
        for (byte b : list) {
            if (b == '\n')
                sb.append('\n');
            else
                sb.append((char) b);
        }
        return sb.toString();
    }
}

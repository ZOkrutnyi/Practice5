package com.delphi.app.readers;

import com.delphi.app.loggers.LoggerHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReaderImpl implements Reader {
    private final String filepath;
    LoggerHandler logHandler = new LoggerHandler();
    Logger logger = logHandler.createLogger();

    public ReaderImpl(String filePath) {
        this.filepath = filePath;
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
            logger.info("read method failed to read");
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

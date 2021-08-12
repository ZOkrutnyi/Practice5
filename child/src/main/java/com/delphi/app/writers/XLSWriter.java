package com.delphi.app.writers;

import com.delphi.app.loggers.LoggerHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSWriter implements Writer {

    private static final char DELIMITER = '\t';
    private final String filepath;
    LoggerHandler logHandler = new LoggerHandler();
    Logger logger = logHandler.createLogger();

    public XLSWriter(String filepath)
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
            logger.log(Level.INFO,"failed to write to file");
        }
    }
}

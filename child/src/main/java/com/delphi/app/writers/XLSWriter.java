package com.delphi.app.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSWriter implements Writer {

    private static final char DELIMITER = '\t';
    private final String filepath;
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public XLSWriter(String filepath)
    {
        this.filepath = filepath;
        try {
            FileHandler fileHandler = new FileHandler(this.getClass().getSimpleName()+".log");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.INFO,"failed to create file handler");
        }
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

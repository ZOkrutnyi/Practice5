package com.delphi.app.loggers;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerHandler implements AbstractLogger {
    private final Logger logger;

    public LoggerHandler() {
        InputStream stream = this.getClass().getClassLoader().
                getResourceAsStream("log.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger = Logger.getLogger(this.getClass().getName());
    }

    @Override
    public Logger createLogger() {
        return logger;
    }
}

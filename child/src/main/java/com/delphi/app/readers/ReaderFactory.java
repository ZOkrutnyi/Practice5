package com.delphi.app.readers;


import java.util.logging.Logger;

public class ReaderFactory {
    private final String filepath;
    Logger log = Logger.getLogger(this.getClass().getName());


    public ReaderFactory(String filepath) {
        this.filepath = filepath;
    }

    public Reader createReader() {
        if (filepath.contains(".xml"))
            return new XMLReader(filepath);
        else
//            try {
//                String str = log.logp(Level.INFO,this.getClass().getCanonicalName(),"createReader()","create writer issue");
//                new FileWriter("log.txt").write(str);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
            throw new IllegalArgumentException();
    }
}

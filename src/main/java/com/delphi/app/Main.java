package main.java.com.delphi.app;

import java.util.List;

public class Main {
    private static final String FILE_PATH = "cd_catalog.xml";
    public static final List<CD> ELEMENTS = AppendElements.append(FILE_PATH);
    public static void main(String[] args) throws IllegalAccessException {
        ParseCSV c = new ParseCSV();
        System.out.println(c.getValue("ARTIST"));
    }
}

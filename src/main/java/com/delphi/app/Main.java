package main.java.com.delphi.app;


public class Main {

    private static final String CSV_FILE_PATH = "newCSV.csv";

    public static void main(String[] args) {
        ParseCSV parseCSV = new ParseCSV();
        CD cds = new CD();
        for (int i = 0; i < 38; i++) {
            parseCSV.parseToCSV(cds.getRow(), CSV_FILE_PATH);
        }
    }
}

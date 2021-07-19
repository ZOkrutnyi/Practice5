package main.java.com.delphi.app.parsers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class XLSXParser extends AbstractParser {
    static int rowNum = 0;
    @Override
    public void parse(String str, String filename) {
        try (Workbook book = new HSSFWorkbook()) {
            Sheet sheet = book.createSheet("cds");

            // Нумерация начинается с нуля
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(str);
            sheet.autoSizeColumn(1);
            book.write(new FileOutputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parse(String[] strings, String filename) {
        try (Workbook book = new HSSFWorkbook()) {
            Sheet sheet = book.createSheet("cds");

            // Нумерация начинается с нуля
            Row row = sheet.createRow(rowNum++);
            for (int cell = 0; cell < strings.length; cell++) {
                row.createCell(cell).setCellValue(strings[cell]);
            }
            sheet.autoSizeColumn(1);
            book.write(new FileOutputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

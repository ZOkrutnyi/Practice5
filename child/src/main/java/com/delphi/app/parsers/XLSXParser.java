package com.delphi.app.parsers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLSXParser extends AbstractParser {
    static int rowNum = 0;
    private static final int START_POINT = 0;

    @Override
    public void parse(String str, String filename) {
        try (Workbook book = new HSSFWorkbook()) {
            Sheet sheet = book.createSheet("cds");

            // Нумерация начинается с нуля
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(str);
            sheet.autoSizeColumn(1);
            book.write(new FileOutputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parse(String[] strings, String fileName) {
        if (!new File(fileName).exists()) {
            writeAtTheBeginning(strings, fileName);
        } else {
            writeToCell(strings, fileName);
        }
    }

    private static void writeToCell(String[] arr, String fileName) {
        try (
                FileInputStream xlsxFile = new FileInputStream(fileName);
                XSSFWorkbook cdBook = new XSSFWorkbook(xlsxFile);
                FileOutputStream outputFile = new FileOutputStream(fileName);
        ) {
            XSSFSheet sheet = cdBook.getSheetAt(START_POINT);
            write(arr, cdBook, outputFile, sheet);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void writeAtTheBeginning(String[] arr, String fileName) {
        try (
                XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream outputStream = new FileOutputStream(fileName)) {

            XSSFSheet sheet = workbook.createSheet();
            write(arr, workbook, outputStream, sheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(String[] arr, XSSFWorkbook workbook, FileOutputStream outputStream, XSSFSheet sheet) throws IOException {
        rowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(++rowNum);
        for (int i = 0; i < arr.length; i++) {
            row.createCell(i).setCellValue(arr[i]);
        }
        workbook.write(outputStream);
    }

}

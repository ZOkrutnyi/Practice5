package com.delphi.app.writers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLSXWriter extends AbstractWriter {
    static int rowNum = 0;
    private static final int START_POINT = 0;

    @Override
    public void write(String[] strings, String fileName) {
        if (!new File(fileName).exists()) {
            writeAtTheBeginning(strings, fileName);
        } else {
            writeToCell(strings, fileName);
        }
    }

    private void writeToCell(String[] arr, String fileName) {
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

    private void writeAtTheBeginning(String[] arr, String fileName) {
        try (
                XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream outputStream = new FileOutputStream(fileName)) {

            XSSFSheet sheet = workbook.createSheet();
            write(arr, workbook, outputStream, sheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(String[] arr, XSSFWorkbook workbook, FileOutputStream outputStream, XSSFSheet sheet) throws IOException {
        rowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(++rowNum);
        for (int i = 0; i < arr.length; i++) {
            row.createCell(i).setCellValue(arr[i]);
        }
        workbook.write(outputStream);
    }

}

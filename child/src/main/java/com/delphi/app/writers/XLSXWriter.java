package com.delphi.app.writers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

class XLSXWriter implements Writer {
    private static final int START_POINT = 0;
    private final String filepath;
    protected XLSXWriter(String filepath)
    {
        this.filepath = filepath;
    }

    @Override
    public void write(String[] strings) {
        if (!new File(filepath).exists()) {
            writeAtTheBeginning(strings, filepath);
        } else {
            writeToCell(strings, filepath);
        }
    }

    private void writeToCell(String[] arr, String fileName) {
        try (
                FileInputStream xlsxFile = new FileInputStream(fileName);
                XSSFWorkbook cdBook = new XSSFWorkbook(xlsxFile);
                FileOutputStream outputFile = new FileOutputStream(fileName)
        ) {
            XSSFSheet sheet = cdBook.getSheetAt(START_POINT);
            write(arr, cdBook, outputFile, sheet);
        } catch (IOException e) {
            e.printStackTrace();
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
        int rowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(++rowNum);
        for (int i = 0; i < arr.length; i++) {
            row.createCell(i).setCellValue(arr[i]);
        }
        workbook.write(outputStream);
    }

}

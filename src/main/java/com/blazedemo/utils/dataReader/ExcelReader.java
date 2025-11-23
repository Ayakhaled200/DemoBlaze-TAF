package com.blazedemo.utils.dataReader;

import com.blazedemo.utils.logs.LogsManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String TEST_DATA_PATH = "src/test/resources/test-data/";

    // bad practice
    // row and col > 0
    public static String getExcelData(String excelFilename, String sheetName, int rowNum, int colNum) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;

        String cellData;

        try {
            workBook = new XSSFWorkbook(TEST_DATA_PATH + excelFilename);
            sheet = workBook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

            return cellData;

        } catch (Exception e) {
            LogsManager.error("Exception occurred while reading Excel data: ", excelFilename, e.getMessage());
            return "";
        }
    }
}

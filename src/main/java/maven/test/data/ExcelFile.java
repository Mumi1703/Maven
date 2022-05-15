package maven.test.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	public static void excelReadOne() throws IOException {
		File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);
	}
	public static void excelWriteOne() throws IOException {
	File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet cSheet = wb.createSheet("Aiite");
	Row createRow = cSheet.createRow(0);
	Cell createCell = createRow.createCell(0);
	createCell.setCellValue("Java");
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
	wb.close();
}
	public static void excelUpdate() throws IOException {
		File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Aiite");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		if(value.equals("Java")) {
			cell.setCellValue("Selenium");
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}
	public static String excelReadTwo(int row, int cell) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\INN\\SampleWorkspace\\MavenSample\\src\\main\\resources\\TestData\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		Row row1 = sheet.getRow(row);
		Cell cell2 = row1.getCell(cell);
		CellType type = cell2.getCellType();
		 if (type == CellType.STRING) {
			 value = cell2.getStringCellValue();
			 System.out.println(value);
         } 
//		 else if (type == CellType.NUMERIC) {
//              		double value1 = cell2.getNumericCellValue();
//              		System.out.println(value1);
//         } 
	else  if ((type == CellType.STRING)&&(DateUtil.isCellDateFormatted(cell2))) {
        	 Date dateCellValue = cell2.getDateCellValue();
			// date formatting
				SimpleDateFormat sc = new SimpleDateFormat("dd-MMM-yyyy");
				value = sc.format(dateCellValue);
				System.out.println(value);
         } 
		return value;
	}

public static void main(String[] args) throws IOException {
		//excelReadOne();
		//excelWriteOne();
		//excelUpdate();
		excelReadTwo(1, 0);
}
}

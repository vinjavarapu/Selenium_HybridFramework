package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelFile {

	public static <XSSFWorkbook> void main(String[] args) throws IOException {
		
		
		File src = new File("./TestData//Ravi.xls");
		
		FileInputStream fs = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		HSSFSheet sheet1 = wb.getSheetAt(0);
		
		String data = sheet1.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(data);
		
	
		// TODO Auto-generated method stub

	}

}

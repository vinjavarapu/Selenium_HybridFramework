package DDT_Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	public ExcelDataConfig(String excelpath) {
		
		
		try {
			File src = new File(excelpath);
			
			FileInputStream fs = new FileInputStream(src);
			
			 wb = new HSSFWorkbook(fs);
			
			
		} 
		catch (Exception e) {
			
			
			System.out.println(e.getMessage());
		
		}
		
	}
	public String getData(int sheetnumber, int row, int column) {
		
		 sheet1 = wb.getSheetAt(sheetnumber);
		 
		 String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	


}

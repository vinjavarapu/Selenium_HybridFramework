package DDT_Library;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;

public class Readexcel {

	public static void main(String[] args) {
		
		
		ExcelDataConfig excel = new ExcelDataConfig("./TestData//Ravi.xls");
		
		String data =   excel.getData(0, 1, 0);
		
		System.out.println(data);
		
		
		
	

	}

}

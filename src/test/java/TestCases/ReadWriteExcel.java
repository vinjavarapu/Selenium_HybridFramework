package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
/**
 * @author Admin
 *
 */
public class ReadWriteExcel
{
    WebDriver driver;
    WebDriverWait wait;
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
 
 @BeforeTest
 public void TestSetup()
{
    // Set the path of the Firefox driver.
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
     
    // Enter url.
    driver.get("http://demo.guru99.com/V4/");
    driver.manage().window().maximize();
     
    wait = new WebDriverWait(driver,30);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
  
 @Test
 public void ReadData() throws IOException
 {
     // Import excel sheet.
     File src=new File("./TestData//Ravi.xls");
      
     // Load the file.
     FileInputStream finput = new FileInputStream(src);
      
     // Load he workbook.
    workbook = new HSSFWorkbook(finput);
      
     // Load the sheet in which data is stored.
     sheet= workbook.getSheetAt(0);
      
     for(int i=1; i<=sheet.getLastRowNum(); i++)
     {
         // Import data for Email.
         cell = sheet.getRow(i).getCell(1);
       //  cell.setCellType(Cell.CELL_TYPE_STRING);
         
         driver.findElement(By.name("uid")).sendKeys(cell.getStringCellValue());
         
          
         // Import data for password.
         cell = sheet.getRow(i).getCell(2);
         driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
    
       //  driver.findElement(By.xpath("//*[@id=\"session_password\"]")).sendKeys(cell.getStringCellValue());
        // driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
         
        driver.findElement(By.name("btnLogin")).click();
        
        driver.switchTo().alert().accept();
          
         // Write data in the excel.
       FileOutputStream foutput=new FileOutputStream(src);
         
        // Specify the message needs to be written.
        String message = "Data Imported Successfully.";
         
        // Create cell where data needs to be written.
        sheet.getRow(i).createCell(3).setCellValue(message);
          
        // Specify the file in which data needs to be written.
        FileOutputStream fileOutput = new FileOutputStream(src);
         
        // finally write content
        workbook.write(fileOutput);
         
         // close the file
        fileOutput.close();
             
     }
 } 
}
package DDT_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuruLoginDataDriven2 {
	
	WebDriver driver;
	
	@Test(dataProvider="GuruLoginData")
	public void LoginTo(String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		driver.switchTo().alert().accept();
	}
	
	@DataProvider(name="GuruLoginData")
	public Object [][] passData() {
		
		
		ExcelDataConfig config = new ExcelDataConfig("./TestData//Ravi.xls");
		
		int rows = config.getRowCount(0);
		
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		
	
		
		return data;
		
		
	}

}

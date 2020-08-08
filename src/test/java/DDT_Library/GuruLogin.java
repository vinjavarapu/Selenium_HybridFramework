package DDT_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuruLogin {
	
	WebDriver driver;
	
	
	@Test
	

	public void Login() throws InterruptedException {
		
		ExcelDataConfig excel = new ExcelDataConfig("./TestData//Ravi.xls");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/v4/");
		
		driver.findElement(By.name("uid")).sendKeys(excel.getData(0, 0, 0));
		driver.findElement(By.name("password")).sendKeys(excel.getData(0, 0, 1));
		driver.findElement(By.name("btnLogin")).click();
		
		
		
		
		
	}

}

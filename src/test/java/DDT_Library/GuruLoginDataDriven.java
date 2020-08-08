package DDT_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuruLoginDataDriven {
	
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
		
		
		Object[][] data = new Object[3][2];
		
		data[0][0]= "admin1";
		data[0][1]= "admin1";
		
		data[1][0]= "admin2";
		data[1][1]= "admin2";
		
		data[2][0]= "admin3";
		data[2][1]= "admin3";
		
		return data;
		
		
	}

}

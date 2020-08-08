package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.Configreader;

public class Login extends BaseClass{
	

	Configreader reader;
	
	@Test
	public void LoginToApplication() throws IOException {
		
		reader = new Configreader();
		driver.findElement(By.name(reader.uname_locator())).sendKeys(reader.enterusername());
		driver.findElement(By.name("password")).sendKeys("ravi@123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div[2]/form/div[4]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	

}

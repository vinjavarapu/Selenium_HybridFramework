package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	Configreader reader;
	

	@BeforeClass
	
	public void Setup() throws IOException {
		
		reader = new Configreader();
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		driver.get(reader.URL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass

	public void Quit() {
	
		driver.quit();
}

	
	

}

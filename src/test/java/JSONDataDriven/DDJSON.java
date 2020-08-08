package JSONDataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDJSON {
	
	WebDriver driver;
	
	@Test(dataProvider="dp")
	public void Login(String data) {
		
		
		String users[] = data.split(",");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys(users[0]);
		driver.findElement(By.name("password")).sendKeys(users[1]);
		driver.findElement(By.name("btnLogin")).click();
		
		
		
		
	}
	
	@DataProvider(name="dp")
	public String[] readJson() throws IOException, ParseException
	{
		
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("./TestData//logindata.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject userloginjsonobj = (JSONObject)obj;
		
		JSONArray userloginarry = (JSONArray)userloginjsonobj.get("userlogins");
		
		String arr[] = new String[(userloginarry.size())];
		
		for(int i=0; i<userloginarry.size(); i++)
		{
			JSONObject users = (JSONObject)userloginarry.get(i);
			String usersdata = (String) users.get("username");
			String passworddata = (String)users.get("password");
			arr[i] = usersdata + ","+ passworddata;
					
		}
		return arr;
		
	}

}

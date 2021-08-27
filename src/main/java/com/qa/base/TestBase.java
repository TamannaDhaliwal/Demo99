package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtils;

public class TestBase {

	public static Properties prop;
	public static  WebDriver driver;
	
public TestBase()  {
	 prop = new Properties();
	FileInputStream ip;
	try {
		ip = new FileInputStream("C:\\Tamanna\\RestAssured\\Guru99Demo\\src\\main\\java\\com\\qa\\config\\config.prop");
		prop.load(ip);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public static void initialization() {
		String browserName	= prop.getProperty("browser");
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();		
			}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtils.Time_ImplicitValue,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	public static void takeScreenshotAtFailOfTest()  {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Tamanna\\RestAssured\\Guru99Demo\\screenshots\\testFail.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

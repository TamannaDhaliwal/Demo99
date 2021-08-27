package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.CustomListener;
@Listeners(CustomListener.class)
public class HomePageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super ();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 homePage = new HomePage();
	}
	
	public void verifyTitle() {
	String title  =	homePage.validateHomeTitle();
    System.out.println(title);
    Assert.assertEquals("Guru99 Bank Manager HomePage11",title);
	}
	
	public void verifyMangerId() {
	String id =	homePage.validateManagerId();
	System.out.println(id);
	   Assert.assertEquals("Manger Id : mngr349989",id);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

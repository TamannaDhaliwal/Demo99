package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.CustomListener;
@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super ();
	}
	
	@BeforeMethod
	public void setUp() {
	initialization();
	loginPage =new LoginPage();
	}
	
	@Test
	public void loginApp() {
				homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifyTitle() {
	String title =	loginPage.validateLoginTitle()	;
	System.out.println(title);
	Assert.assertEquals(title, "Guru99 Bank Home Page11");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}

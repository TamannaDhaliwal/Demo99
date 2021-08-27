package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath ="//input[@type='text']")
	WebElement userId  ;
	
	@FindBy(xpath ="//input[@type='password']")
	WebElement password	;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginBtn	;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String userN,String pwd) {
		userId.sendKeys(userN);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}
	
	public String validateLoginTitle() {
		return driver.getTitle()	;
	}
	
	
}

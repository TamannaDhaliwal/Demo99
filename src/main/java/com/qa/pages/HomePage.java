package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath ="//td[@style='color: green']")
	WebElement ManagerId  ;
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
		public String validateManagerId() {
			ManagerId.getText();
			return new String();
	}
	
	public String validateHomeTitle() {
		return driver.getTitle()	;
	}
	
	
	
	
	
	
	
	
}

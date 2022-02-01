package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	
	WebDriver driver;
	
	public ContactInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement succesfullMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
		
		
	}
	

}

package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class Home extends WebDriverUtility{
	WebDriver driver;// global driver variable
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	@FindBy(linkText = "Product")
	private WebElement productLink;
	
	@FindBy(xpath = "//img[contains(@src,'user')]")
	private WebElement adminstatorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
		
	}
	public WebElement getProductLink() {
		return productLink;
		
	}
	public WebElement getAdminstatorImg() {
		return adminstatorImg;
		
		
	}
	public WebElement getLSignOutink() {
		return signOutLink;
			
	}
	public void logout() {
		
		mouseOver(driver, adminstatorImg);
		signOutLink.click();
	}

}


package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContacts extends WebDriverUtility{
	
	WebDriver driver;// global driver variable
	public CreateNewContacts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img[contains(@src,'select')]")
	private WebElement selectOrg;
	/*
	 * used to create New contact With Mandatory information
	 * @param CotactlastName	 
	 */
	 public void CreateContact(String contactLastName) {
		 
		 lastNameEdt.sendKeys(contactLastName);
		 saveBtn.click();
	 }
	 
 public void CreateContact(String contactLastName,String orgName) {
		 
		 lastNameEdt.sendKeys(contactLastName);
		 selectOrg.click();
		 switchToWindow(driver, "Accounts");
		 Organisation op=new Organisation(driver);
		 op.getSearchEdt().sendKeys(orgName);
		 op.getSearchBtn().click();
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		 switchToWindow(driver, "Contacts");
		 saveBtn.click();
	 }

}

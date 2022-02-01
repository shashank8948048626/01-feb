package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewOrganisation extends WebDriverUtility{
	public CreateNewOrganisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryEdt;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryEdt() {
		return industryEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String industryName) {
		orgNameEdt.sendKeys(orgName);
		select(industryEdt, industryName);
		saveBtn.click();
	}

}

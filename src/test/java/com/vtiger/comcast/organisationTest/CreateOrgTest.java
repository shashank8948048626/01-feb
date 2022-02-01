package com.vtiger.comcast.organisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganisation;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organisation;
import com.vtiger.comcast.pomrepositorylib.OrganisationInfo;

public class CreateOrgTest extends BaseClass {
	@Test(groups = { "smokeTest" })
	public void createOrgTest() throws Throwable {

		int random = jLib.getRandomNumber();
		/* read test data */
		String orgName = eLib.getDataFromExcel("org", 1, 4) + jLib.getRandomNumber();

		/* step 3: navigate to Org */

		Home hp = new Home(driver);
		hp.getOrganizationLink().click();

		/* step 4: navigate to create org Page */

		Organisation op = new Organisation(driver);
		op.getCreateOrgImg().click();
		/* step 5: create org */

		CreateNewOrganisation cnop = new CreateNewOrganisation(driver);
		cnop.createOrg(orgName);
		/* step 6: verify */

		OrganisationInfo oinfop = new OrganisationInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		String actSucMsg = oinfop.getSuccesfullMsg().getText();
		if (actSucMsg.contains(orgName)) {
			System.out.println("org is created succesfully==>PASS");
		} else {
			System.out.println("org is not created succesfully==>FAIL");

		}

	}

	@Test(groups = { "regressionTest" })
	public void createorgWithIndustrytest() throws Throwable {

		int randomInt = jLib.getRandomNumber();
		/* read test data */
		String orgName = eLib.getDataFromExcel("org", 1, 4) + jLib.getRandomNumber();
		String indName = eLib.getDataFromExcel("org", 1, 3);

		/* step 3: navigate to Org */

		Home hp = new Home(driver);
		hp.getOrganizationLink().click();

		/* step 4: create new org */

		Organisation op = new Organisation(driver);
		op.getCreateOrgImg().click();

		CreateNewOrganisation cnop = new CreateNewOrganisation(driver);
		cnop.createOrg(orgName, indName);
		/* verify */

		OrganisationInfo oinfop = new OrganisationInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		String actSucMsg = oinfop.getSuccesfullMsg().getText();
		if (actSucMsg.contains(orgName)) {
			System.out.println("org is created succesfully==>PASS");
		} else {
			System.out.println("org is not created succesfully==>FAIL");

		}
	}
}

package com.vtiger.comcast.organisationTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.vtiger.comcast.pomrepositorylib.ContactInformation;
import com.vtiger.comcast.pomrepositorylib.Contacts;
import com.vtiger.comcast.pomrepositorylib.CreateNewContacts;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganisation;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Organisation;
import com.vtiger.comcast.pomrepositorylib.OrganisationInfo;

public class CreateContactTest  extends BaseClass{

	@Test(groups= {"smokeTest"})
public void createContact() throws Throwable {
		
		/*read test data*/
	String conName = eLib.getDataFromExcel("org", 2,4 )+jLib.getRandomNumber();

	
	/*step 3: navigate to Contact*/
	Home hp = new Home(driver);
	hp.getContactLink().click();
			
	/* step 4: navigate to create contact Page*/
	
	Contacts cp = new Contacts(driver);
	cp.getCreateContactImg().click();
	
	/* step 5: create Contact */
	CreateNewContacts cnp = new CreateNewContacts(driver);
	cnp.CreateContact(conName);
	
	
	/* step 6: verify contact details */
	
 ContactInformation ci = new ContactInformation (driver);
	
	String actSucMsg = ci.getSuccesfullMsg().getText();
	if (actSucMsg.contains(conName)) {
		System.out.println("contact is created succesfully==>PASS");
	}
	else {
		System.out.println("contact is not created succesfully==>FAIL");
		
	}
		
	}
	@Test(groups= {"regressionTest"})
	public void CreateContactWithOrgTest() throws Throwable {
	
		int random = jLib.getRandomNumber();
		
		/*read test data*/
		String orgName = eLib.getDataFromExcel("org", 1,4 )+jLib.getRandomNumber();
		String conName = eLib.getDataFromExcel("org", 2,4 )+jLib.getRandomNumber();
		
		
		
	/*step 3: navigate to Org*/
		
		Home hp = new Home(driver);
		hp.getOrganizationLink().click();
				
		/* step 4: navigate to create org Page*/
		
		Organisation op=new Organisation(driver);
		op.getCreateOrgImg().click();
		
		/* step 5: create org */
		
		CreateNewOrganisation cnop = new CreateNewOrganisation(driver);
		cnop.createOrg(orgName);
		
		/*wait for header element*/
		OrganisationInfo oi=new OrganisationInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccesfullMsg());
		
		/*step 3: navigate to Contact*/
		
		hp.getContactLink().click();
				
		/* step 4: navigate to create contact Page*/
		
		Contacts cp = new Contacts(driver);
		cp.getCreateContactImg().click();
		
		/* step 5: create Contact */
		CreateNewContacts cnp = new CreateNewContacts(driver);
		cnp.CreateContact(conName, orgName);
		
		
		/* step 6: verify contact details */
		
	 ContactInformation ci = new ContactInformation (driver);
		ci.getSuccesfullMsg().getText();
	 
		String actSucMsg = ci.getSuccesfullMsg().getText();
		if (actSucMsg.contains(conName)) {
			System.out.println("contact is created succesfully==>PASS");
		}
		else {
			System.out.println("contact is not created succesfully==>FAIL");
			
		}
		
		String actOrgMsg = ci.getOrgNameInfo().getText();
		if (actOrgMsg.contains(orgName)) {
			System.out.println("contact is created succesfully==>PASS");
		}
		else {
			System.out.println("contact is not created succesfully==>FAIL");
			
		}
		
	}	
}

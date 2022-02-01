package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.vtiger.comcast.pomrepositorylib.Home;

@Listeners(com.crm.GenericLibrary.LisImpClass.class)
public class SampleTest extends BaseClass {
	@Test
	
	public void contactTest() {
		
		Home hp = new Home(driver);
		hp.getContactLink().click();
		
		Assert.assertEquals("A", "B");	
		
	}
	

}

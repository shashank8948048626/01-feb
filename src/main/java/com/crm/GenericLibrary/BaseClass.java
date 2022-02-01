package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class BaseClass {
	public static WebDriver sDriver;
	public WebDriver driver;
	  /*Object Creation for Lib*/
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		private WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("========================connect to DB========================");
               
	}
	//@Parameters("browser")	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable  {
		/*read the common data from Properties File*/
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER=fLib.getPropertyKeyValue("browser");
		/* Launch the Browser*/
		System.out.println("=============Launch the Browser=======");
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();//launched
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();//launched
		}
		else
		{
			System.out.println("invalid Browser");//executed
		}
		sDriver = driver; 
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		   driver.get(URL);
	        /* step 1 : login */
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
	      /*step 6 : logout*/
		Home homePage = new Home(driver);
      homePage.logout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}


}

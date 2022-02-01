package com.crm.comcast.orgTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");	
		String BROWSER = pobj.getProperty("password");
		Random ran =new Random();
		
		
		FileInputStream fis_e = new FileInputStream("./data/TestscriptData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis_e);
		String Orgname = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
		
		WebDriver driver=null;
	    if(BROWSER.equals("firefox")) 
	    {
	    	driver = new FirefoxDriver();
	    }
	    else if(BROWSER.equals("chrome")) 
	    {
	    	driver = new ChromeDriver();
	    }
	    else
	    {
	    	driver = new ChromeDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String actualtext=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualtext.contains(Orgname))
		{
			System.out.println("Test Case passed");
		}
		else
		{
			System.out.println("Test Case failed");
		}
		Actions a = new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("//td[@class='small'])[2]/img"));
		a.moveToElement(lgo).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();		
	}

}

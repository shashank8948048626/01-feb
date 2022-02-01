package com.crm.Product.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateMultipleProduct {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Import Products']")).click();
		File f = new File("./data/vtigerfile.csv");
		String absolutepath = f.getAbsolutePath();
		driver.findElement(By.id("import_file")).sendKeys(absolutepath);
        driver.findElement(By.id("auto_merge")).click();
        WebElement plistbx = driver.findElement(By.id("available_fields"));
         
Select s = new Select(plistbx);
s.selectByIndex(0);
s.selectByIndex(1);
s.selectByIndex(2);
s.selectByIndex(11);
s.selectByIndex(13);
driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
Thread.sleep(3000);
driver.findElement(By.name("next")).click();
WebElement field = driver.findElement(By.name("mapped_fields"));
Select c = new Select(field);

c.selectByIndex(1);
driver.findElement(By.id("productname_defaultvalue")).sendKeys("sss");

Thread.sleep(3000);
driver.findElement(By.xpath("//input[@type='submit']")).click();

	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a = new Actions(driver);
	a.moveToElement(logout).perform();
	driver.findElement(By.linkText("Sign Out")).click();		
		
	}


	}



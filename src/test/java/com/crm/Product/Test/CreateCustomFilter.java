package com.crm.Product.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCustomFilter {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("Create Filter")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("Product_Details_Deepu");
		driver.findElement(By.name("setDefault")).click();
		driver.findElement(By.name("setMetrics")).click();
		driver.findElement(By.name("setStatus")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions s = new Actions(driver);
		s.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
	}

}

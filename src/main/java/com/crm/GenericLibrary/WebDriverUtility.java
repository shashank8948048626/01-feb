package com.crm.GenericLibrary;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author shashank
 *
 */
public class WebDriverUtility {
	private static final int Iterator = 0;
	/**
	 * 
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	/**
	 * This method wait for the element to be visible 
	 * 
	 * @param driver
	 * @param selement
	 */
public void waitForElementVisibility(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method wait for the element to be clicked , its custom wait created to aviod elementinterAceptable Exception
 * @param element
 * @throws InterruptedException 
 * @throws throwable
 */
public void waitAndClick(WebElement element) throws InterruptedException {
	int count = 0;
	while(count < 0) {
		try {
			element.click();
			break;
		}catch(Throwable e) {
			Thread.sleep(1000);
			count++;
		}
		}
}
/**
 * this method enables user to handle dropdown using visible text
 * @param element
 * @param option
 */
public void select(WebElement element, String option) {
	Select select = new Select(element);
	select.selectByVisibleText(option);
}
/**
 * this method enables user to handle dropdown using index
 *@param element
 *@param index
 */
public void select(WebElement element, int index) {
	Select select=new Select(element);
	select.selectByIndex(index);
}
 /**
  * This method will perform mouse over action
  * @param driver
  * @param element
  */
public void mouseOver(WebDriver driver,WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
  }
/**
 * This method performs right click operation
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method helps to switch from one window to another
 * @param
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver, String partialWinTitle) {
	Set<String>window=driver.getWindowHandles(); 
	java.util.Iterator<String>it = window.iterator();
	while(it.hasNext())
	{
		String winld=it.next();
		String title = driver.switchTo().window(winld).getTitle();
		if(title.contains(partialWinTitle))
		{
			break;
		}
	}
}
/**
 * Accept alert
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * cancel alert
 * @param driver
 */
public void cancelAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * this method is used for scrolling action in a webpage
 * @param driver
 * @param element
 */
public void scrollToWebelement(WebDriver driver, WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	int y= element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
}

public void switchFrame(WebDriver driver, int index) {
	driver.switchTo().frame(index);
	}
public void switchFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void switchFrame(WebDriver driver, String idOrName) {
	driver.switchTo().frame(idOrName);
}
public void takeScreenshot (WebDriver driver, String screenshotName) throws Throwable  {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/"+screenshotName+".PNG");
	Files.copy(src, dest);	
}

public void maximize(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * pass enter Key appertain in to browser
 * @param driver
  */
public void passEnterKey(WebDriver driver) {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
	}











import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericLibrary.WebDriverUtility;

public class FlipkartPractise {
	
public static void main(String[] args) {
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.name("q")).sendKeys("samsung f22");
	
}
}

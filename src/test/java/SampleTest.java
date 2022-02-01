import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class SampleTest {
public static void main(String[] args) throws Throwable {
		
		
        /* create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
                 FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/* get ramDomData */
		int randomNum = jLib.getRandomNumber();
		
		/* read common data from Properties File*/

		 String BROWER = fLib.getPropertyKeyValue("browser");
		 String URL = fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
		 
		 /* read test data from Excel File*/

		    String orgName = eLib.getDataFromExcel("contact", 2, 3) + randomNum;
		    String conactName = eLib.getDataFromExcel("contact", 1, 3) + randomNum;
	
		   
		 
         
         /* launch the Browser */ 
         WebDriver driver = null;
         if(BROWER.equals("chrome")) {
              driver = new ChromeDriver();
         }else if(BROWER.equals("firefox")){
        	  driver = new FirefoxDriver();
         }else if(BROWER.equals("ie")){
       	  driver = new InternetExplorerDriver();
        }else {
            driver = new ChromeDriver();
        }

wLib.waitUntilPageLoad(driver);
driver.get(URL);
         /* step 1 : login to APP */ 
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         /* step 1 : navigate to Org Page */ 
         driver.findElement(By.linkText("Organizations")).click();

         /* step 2 :  navigate to CREATE  Org Page*/ 
         driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         /* step 3 : create a new Org */
         driver.findElement(By.name("accountname")).sendKeys(orgName);
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

         WebElement headerWb = driver.findElement(By.className("dvHeaderText"));

         wLib.waitUntilPageLoad(driver);
         
         
         /* step 4 : navigate to Contact Page */ 
         driver.findElement(By.linkText("Contacts")).click();
        
         /* step 5 :  navigate to CREATE  Coantct Page*/ 
         driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        
         
         /* step 6 : create a new contact With org Name */
         driver.findElement(By.name("lastname")).sendKeys(conactName);
         driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
  
          wLib.switchToWindow(driver, "Accounts");
    
    
         driver.findElement(By.name("search_text")).sendKeys(orgName);
         driver.findElement(By.name("search")).click();
         driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
         wLib.switchToWindow(driver, "Contacts");
         
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         
         
    
        wLib.mouseOver(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
        driver.findElement(By.linkText("Sign Out")).click();
        driver.close();
        
        

	}
	
	

	

}



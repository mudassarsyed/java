package com.browserstack;

/*
 1.3 BrowserStack Inception
Using BrowserStack Live, go to www.google.com and search for “BrowserStack”.
Write a BrowserStack Automate test that executes a BrowserStack Live test that does the same test.
Run the same test in 3 different browsers (Firefox, IE)
Run above test across all 3 browsers in parallel.
Run above tests with Local Testing’s “force local” option enabled
Mark any failing tests as failed in the Automate Dashboard using the REST API

 */


/* Selenium Intro
In the language of your choice, use Selenium to load the www.amazon.com desktop home page. Search for the product "iPhone 6". Apply the following filters to the results:  
Price range: $700 or higher
Brand: Apple
Display a list in your console containing the product name, price, and a link to the product details page for each search result item.
Automate the above process with a BrowserStack remote driver.
Create parallel BrowserStack remote drivers to run simultaneously across Chrome, Firefox, and Safari.
*/




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocalTest {
	
  
  

  //public static final String USERNAME = "mudassarsyed2";
  //public static final String AUTOMATE_KEY = "8ZezGR6GyZjP2ZqrXphh";
  //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


//@BeforeTest  // With this I have specified the desired OS/browser for execution 
//@Parameters({"browser", "version", "platform"} )
//public void setUp(String browser, String version, String platform) throws Exception {
/*DesiredCapabilities capability = new DesiredCapabilities();
capability.setCapability("platform", platform);
capability.setCapability("browserName", browser);
capability.setCapability("browserVersion", version);
capability.setCapability("project", "Dektop");
capability.setCapability("build", "1.3");
capability.setCapability("browserstack.safari.enablePopups", "true");
capability.setCapability("browserstack.debug", "true");
//driver = new RemoteWebDriver(new URL(URL), capability);
 * 
 */
//System.setProperty("webdriver.chrome.driver","/Users/mudassarsyed/chromedriver");
//driver = new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
//}


//@Test
public static void main(String args[])
{
	try {
	
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver","/Users/mudassarsyed/chromedriver");
			driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    driver.get("https://www.browserstack.com/live");
    driver.findElement(By.id("accept-cookie-notification")).click();
    driver.findElement(By.linkText("Sign in")).click();
    WebElement uname=driver.findElement(By.id("user_email_login"));
    uname.sendKeys("mudassar.demo@browserstack.com");
    WebElement pwd = driver.findElement(By.id("user_password"));
    pwd.sendKeys("P25panda@tcs");
    
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("user_submit"))).click();
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.linkText("Close"))).click();
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("skip-local-installation"))).click();
  
    
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.linkText("74"))).click();
    
    
    new WebDriverWait(driver, 200);
    System.out.println("1");
    Thread.sleep(30000);
    System.out.println("2");
    WebElement randomElement = driver.switchTo().activeElement();
    System.out.println("3");
   //randomElement.click();
    randomElement.sendKeys("browserstack");
    System.out.println("4");
    randomElement.sendKeys(Keys.ENTER);
    
 
    }
    
	
	catch(Exception e)
	{
    	System.out.println(e);
    }
}

	
    
//@AfterMethod  //Here I will tell the system what needs to be done after all the methods in the test have been executed
//public void tearDown() throws Exception {
//driver.quit();
//}
}
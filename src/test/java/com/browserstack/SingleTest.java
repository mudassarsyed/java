package com.browserstack;
/* Selenium Intro
In the language of your choice, use Selenium to load the www.amazon.com desktop home page. Search for the product "iPhone 6". Apply the following filters to the results:  
Price range: $700 or higher
Brand: Apple
Display a list in your console containing the product name, price, and a link to the product details page for each search result item.
Automate the above process with a BrowserStack remote driver.
Create parallel BrowserStack remote drivers to run simultaneously across Chrome, Firefox, and Safari.
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class SingleTest {
	
  public WebDriver driver;
  

  public static final String USERNAME = "**************";
  public static final String AUTOMATE_KEY = "***************";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


@BeforeTest  // With this I have specified the desired OS/browser for execution 
@Parameters({"browser", "version", "platform"} )
public void setUp(String browser, String version, String platform) throws Exception {
DesiredCapabilities capability = new DesiredCapabilities();
capability.setCapability("platform", platform);
capability.setCapability("browserName", browser);
capability.setCapability("browserVersion", version);
capability.setCapability("project", "Dektop");
capability.setCapability("build", "1.2 Selenium Intro");
capability.setCapability("browserstack.safari.enablePopups", "true");
driver = new RemoteWebDriver(new URL(URL), capability);
}


@Test
public void desktopbrowsertest() throws Exception {
	
	try {
    driver.get("http://www.amazon.com");
    
    WebElement product = driver.findElement(By.name("field-keywords"));
    product.sendKeys("iPhone X");
    product.submit();
    
    WebDriverWait wait =new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='a-icon a-icon-dropdown']")));
    
    Thread.sleep(5000);  //thought of doing it quick , hence not used wait until(explicit wait)
    driver.findElement(By.xpath("//span[@class='a-dropdown-container']")).click();
    
    Thread.sleep(1000);
    driver.findElement(By.id("s-result-sort-select_1")).click();
    
    Thread.sleep(1000);  //thought of doing it quick , hence not used wait until(explicit wait)
    driver.findElement(By.xpath("//li[@id='p_89/Apple']/span/a/span")).click();
    Thread.sleep(1000);
    
    
    List <WebElement> name = driver.findElements(By.xpath("//a/span[@class='a-size-medium a-color-base a-text-normal']"));
    List <WebElement>  namehref = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
    List <WebElement>  price = driver.findElements(By.xpath("//a/span/span[@class='a-offscreen']"));
    
	
	
	for (int i=0;i<name.size();i++) {
		
		System.out.println(name.get(i).getText() + "  " + " " + price.get(i).getAttribute("innerHTML") + "  " + namehref.get(i+1).getAttribute("href") );
		
	}
	
	
    
	}
    

	
	catch(Exception e)
	{
    	System.out.println(e);
    }
}
	
    
@AfterMethod  //Here I will tell the system what needs to be done after all the methods in the test have been executed
public void tearDown() throws Exception {
driver.quit();
}
}


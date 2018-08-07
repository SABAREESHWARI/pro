package SeleniumPackage;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;


import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



public class TestNGDemo 
{
	
WebDriver driver;
	
@BeforeTest
	
public  void openBrowser()
	{
	
	System.setProperty("webdriver.firefox.bin", "C:/Users/chenitha/AppData/Local/Mozilla Firefox/firefox.exe"); 
	
	FirefoxProfile profile = new FirefoxProfile();
	  
        profile.setPreference("network.proxy.type",1);
	
        profile.setPreference("network.proxy.http", "10.219.96.26");

	profile.setPreference("network.proxy.http_port", 8080);

	profile.setPreference("network.proxy.ssl", "10.219.96.26");
	
        profile.setPreference("network.proxy.ssl_port", 8080);
		
        driver = new FirefoxDriver(profile);
        

	}
	
	
@Test
	
public  void testCaseOne() throws InterruptedException
	{
		
	driver.get("http://demo.opencart.com/");		

	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	

	String title=driver.getTitle();
	
	System.out.println(title);

	Assert.assertEquals(title,"Your Store");
	
}

	
@AfterTest
	
public  void closeBrowser()
	{

	driver.quit();
	
}


}


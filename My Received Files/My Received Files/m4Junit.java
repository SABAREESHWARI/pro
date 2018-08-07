package Selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class m4Junit {
	static FirefoxProfile profile = new FirefoxProfile();
	FirefoxDriver driver = new FirefoxDriver(profile);
	 WebElement element ;
	 @BeforeClass
	 public static void beforeClassTest()
		{
		 System.setProperty("webdriver.firefox.bin",
					"C:/Users/saipna/AppData/Local/Mozilla Firefox/firefox.exe");
		 profile.setPreference("network.proxy.type", 1);
	        profile.setPreference("network.proxy.http", "10.219.96.26");
	        profile.setPreference("network.proxy.http_port", 8080);
	        profile.setPreference("network.proxy.ssl", "10.219.96.26");
	        profile.setPreference("network.proxy.ssl_port", 8080);
		}
	 @Before
		public void beforetest()
		{
			System.out.println("Verification Starting.......");
		}
	 @Test
		public void test() throws InterruptedException 
		{
			String expectedtitle = "Your Store";
		    driver.get("https://demo.opencart.com/");
			String  actualtitle = driver.getTitle();
			System.out.println(actualtitle);
			if (actualtitle.contentEquals(expectedtitle)) {
				System.out.println("Title Test Passed");

			} else {
				System.out.println("Title Test failed");
			}
		     assertEquals(expectedtitle, actualtitle);
		}

		@Test
		public void test2() throws InterruptedException
		{
			driver.get("https://demo.opencart.com/");
			driver.findElement(By.partialLinkText("My Account")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys("Sai Preetha");
			try{
				 element = driver.findElement (By.xpath("//input[@id='input-firstname']"));
			 }
			catch (Exception e){
				}
		     assertNotNull(element);
		}

		@AfterClass
		public static void afterTest()
		{
			 driver.quit();
			System.out.println("Successfully done");
		}
	}
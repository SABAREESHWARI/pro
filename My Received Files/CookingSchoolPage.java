/**
 * 
 */
package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sarulr
 *
 */
public class CookingSchoolPage {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chromedriver.driver", "D:/sarulatha/M4/selenium jars/chromedriver.exe");
		
		   
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("webdriver.chromedriver.driver", "D:/sarulatha/M4/selenium jars/chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		//capabilities.setVersion(version);

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capabilities);
		try {
		driver.get("file:///D:/sarulatha/M4/Demos/case%20study/Recipe_class_registration.htm");
		
		//Verifying title of the page
		System.out.println(driver.getTitle());
		
		System.out.println("Verifying expected title with title in page : "+driver.getTitle().equals("Online Cooking Class Enquiry Form"));
		
		//Verifying whether Online Cooking School is present in the page
		boolean contents=driver.getPageSource().contains("Online Cooking School");	
		System.out.println("Verifying whether Online Cooking School is present in the page : "+contents);
		
		//Filling firstname field using id
		driver.findElement(By.id("fname")).sendKeys("Sarulatha");	
		Thread.sleep(1000);

		//Filling firstname field using name
		driver.findElement(By.name("lname")).sendKeys("Rajendran");	
		Thread.sleep(1000);

		//Filling firstname field using css selector
		driver.findElement(By.cssSelector("#emails")).sendKeys("sararuja@gmail.com");	
		Thread.sleep(1000);

		//Filling firstname field using xpath
		driver.findElement(By.xpath("//*[@id='mobile']")).sendKeys("7894568562");	
		Thread.sleep(1000);

		//Selecting category using index
		Select category=new Select(driver.findElement(By.name("D6")));
		category.selectByIndex(1);	Thread.sleep(1000);
		
		//Verifying user choice whether non veg has been chosen
		WebElement element;
		boolean verifyElement=category.getFirstSelectedOption().equals("Veg");
		System.out.println(verifyElement);

		//Selecting city using value
		Select city=new Select(driver.findElement(By.name("D5")));
		city.selectByValue("bangalore");	
		Thread.sleep(1000);

		//Selecting mode using index
		Select mode=new Select(driver.findElement(By.name("D4")));
		mode.selectByIndex(2);	
		Thread.sleep(1000);

		//Selecting course using visible text
		Select course=new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[9]/td[2]/select")));
		course.selectByVisibleText("4 months");	
		Thread.sleep(1000);
		
		//Initializing Webdriver wait
		WebDriverWait w=new WebDriverWait(driver, 30);  
		w.ignoring(NoSuchElementException.class);
		WebElement P=null;

		//Explicit wait
		P=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[9]/td[2]/select")));
		driver.findElement(By.id("enqdetails")).sendKeys("Regarding Course Timings");	

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Using classname to choose 
		driver.findElement(By.className("auto-style1")).click();

		
//		driver.findElement(By.id("Submit2")).click();

		//Using alert to get text from alert box
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println(alertMsg);

		//Using accept to click ok and proceed to next page
		alert.accept();


		String pageContent = driver.getPageSource();
		if(pageContent .contains("Our location representative will contact you soon."))
			System.out.println("Text is being displayed");
		else
			System.out.println("Text isn't visible");
					
		Thread.sleep(10000);
		}
		catch(Exception ex){
			System.out.println("Hello");
		}
		driver.close();
		
	}

}
